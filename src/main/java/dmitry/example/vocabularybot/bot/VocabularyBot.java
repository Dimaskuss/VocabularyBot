package dmitry.example.vocabularybot.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import dmitry.example.vocabularybot.config.BotConfig;
import dmitry.example.vocabularybot.service.VocabularyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VocabularyBot {

    private final BotConfig botConfig;
    private final VocabularyService vocabularyService;
    private TelegramBot bot;

    @PostConstruct
    public void init() {
        bot = new TelegramBot(botConfig.getBotToken());
        bot.setUpdatesListener(this::processUpdates);
    }

    private int processUpdates(List<Update> updates) {
        for (Update update : updates) {
            if (update.message() != null && update.message().text() != null) {
                handleTextMessage(update.message().chat().id(), update.message().text());
            } else if (update.callbackQuery() != null) {
                handleCallback(update.callbackQuery().maybeInaccessibleMessage().chat().id(), update.callbackQuery().data());
            }
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void handleTextMessage(long chatId, String text) {
        if ("/start".equals(text)) {
            bot.execute(new SendMessage(chatId, "Привет дорогой друг мы здесь чтобы учить English words /test"));

        } else if ("/test".equals(text)) {
            sendNextQuestion(chatId);

        } else if ("/clear".equals(text)) {
            vocabularyService.clearCheckedWordsAndCounter();
            bot.execute(new SendMessage(chatId, "Результаты теста сброшены воспользуйтесь /test для повторного прохождения !!"));
        }
    }

    private void sendNextQuestion(long chatId) {
        String word = vocabularyService.getNextWordToCheck();
        if (word != null) {
            vocabularyService.setCurrentWord(word);
            List<String> options = vocabularyService.generateOptions(word);
            InlineKeyboardMarkup markup = createInlineKeyboardMarkup(options);
            bot.execute(new SendMessage(chatId, "*->  " +word.toUpperCase()+"  <-*" ).replyMarkup(markup).parseMode(ParseMode.Markdown));
        } else {
            bot.execute(new SendMessage(chatId, "_Вы проверили все слова /clear !_").parseMode(ParseMode.Markdown));
        }
    }

    private InlineKeyboardMarkup createInlineKeyboardMarkup(List<String> options) {
        InlineKeyboardButton[] buttons = options.stream()
                .map(option -> new InlineKeyboardButton(option).callbackData(option))
                .toArray(InlineKeyboardButton[]::new);
        return new InlineKeyboardMarkup(buttons);
    }

    private void handleCallback(long chatId, String data) {
        String currentWord = vocabularyService.getCurrentWord();
        if (vocabularyService.isCorrectAnswer(currentWord, data)) {
            bot.execute(new SendMessage(chatId, "Верно "+vocabularyService.Increment(vocabularyService.getCounter())+" из "+vocabularyService.getVocabulary().size()));
            vocabularyService.setCounter(vocabularyService.getCounter()+1);
        } else {
            String correctAnswer = vocabularyService.getVocabulary().get(currentWord);
            bot.execute(new SendMessage(chatId, "Неверно! Правильный ответ: *" +correctAnswer+"*").parseMode(ParseMode.Markdown));
        }
        vocabularyService.markWordAsChecked(currentWord);
        sendNextQuestion(chatId);
    }
}

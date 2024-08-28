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
    private final CommandHandler commandHandler;
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
                commandHandler.handleCommand(update.message().chat().id(), update.message().text());
            } else if (update.callbackQuery() != null) {
                handleCallback(update.callbackQuery().maybeInaccessibleMessage().chat().id(), update.callbackQuery().data());
            }
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }


    private void handleCallback(long chatId, String data) {
        UserSession session = vocabularyService.getUserSession(chatId);


        if (vocabularyService.getDictionaries().containsKey(data)) {
            vocabularyService.selectDictionary(data, chatId);
            sendMessage(chatId, "Вы выбрали словарь: " + data + ". Теперь вы можете начать тестирование с помощью /test.");
            session.clear();
        } else {

            String currentWord = session.getCurrentWord();
            if (currentWord == null) {
                sendMessage(chatId, "Текущее слово не установлено. Пожалуйста, начните тест снова.");
                return;
            }
            if (vocabularyService.isCorrectAnswer(chatId,currentWord, data)) {
                vocabularyService.incrementCounter(chatId);
                int totalWords = session.getCurrentVocabulary().size();
                sendMessage(chatId, "Верно! " + vocabularyService.getCounter(chatId) + " из " + totalWords);
            } else {
                String correctAnswer = session.getCurrentVocabulary().get(currentWord);
                sendMessage(chatId, "Неверно! Правильный ответ: *" + correctAnswer + "*");
            }

            vocabularyService.markWordAsChecked(chatId, currentWord);
            commandHandler.handleCommand(chatId, "/test");
        }
    }

    public void sendMessage(long chatId, String text) {
        bot.execute(new SendMessage(chatId, text).parseMode(ParseMode.Markdown));
    }

    public void sendMessageWithOptions(long chatId, String text, List<String> options) {
        InlineKeyboardMarkup markup = createInlineKeyboardMarkup(options);
        bot.execute(new SendMessage(chatId, text).replyMarkup(markup).parseMode(ParseMode.Markdown));
    }


    private InlineKeyboardMarkup createInlineKeyboardMarkup(List<String> options) {
        if (options == null || options.isEmpty()) {
            throw new IllegalArgumentException("Options list cannot be null or empty");
        }
        InlineKeyboardButton[] buttons = options.stream()
                .filter(option -> option != null && !option.trim().isEmpty())
                .map(option -> new InlineKeyboardButton(option).callbackData(option))
                .toArray(InlineKeyboardButton[]::new);
        if (buttons.length == 0) {
            throw new IllegalStateException("No valid options provided to create buttons");
        }
        return new InlineKeyboardMarkup(buttons);
    }
}
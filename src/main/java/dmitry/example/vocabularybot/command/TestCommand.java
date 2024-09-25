package dmitry.example.vocabularybot.command;

import dmitry.example.vocabularybot.bot.UserSession;
import dmitry.example.vocabularybot.bot.VocabularyBot;
import dmitry.example.vocabularybot.service.VocabularyService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestCommand implements Command {
    private final VocabularyBot vocabularyBot;
    private final VocabularyService vocabularyService;



    public TestCommand(VocabularyBot vocabularyBot, VocabularyService vocabularyService) {
        this.vocabularyBot = vocabularyBot;
        this.vocabularyService = vocabularyService;

    }

    @Override
    public void execute(long chatId, String text) {

        UserSession session = vocabularyService.getUserSession(chatId);

        if (session.getCurrentVocabulary() == null) {
            vocabularyBot.sendMessage(chatId, "Пожалуйста, выберите словарь перед началом теста с помощью команды /select.");
            return;
        }
        String word = vocabularyService.getNextWordToCheck(chatId);

        if (word != null) {
            session.setCurrentWord(word);
            List<String> options = vocabularyService.generateOptions(chatId,word);
            vocabularyBot.sendMessageWithOptions(chatId, "*->  " + word.toUpperCase() + "  <-*", options);
        } else {
            vocabularyBot.sendMessage(chatId,"*"+session.getWrongAnswers().toString().substring(1,session.getWrongAnswers().toString().length()-1)+"*");
            vocabularyBot.sendMessage(chatId, "_Вы проверили все слова в текущем словаре! Воспользуйтесь /select для сброса результатов или выберите другой словарь._");
            session.clearSessionFields();
        }
    }
}
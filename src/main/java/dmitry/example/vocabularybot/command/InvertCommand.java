package dmitry.example.vocabularybot.command;

import dmitry.example.vocabularybot.bot.UserSession;
import dmitry.example.vocabularybot.bot.VocabularyBot;
import dmitry.example.vocabularybot.service.VocabularyService;
import org.springframework.stereotype.Component;


import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InvertCommand implements Command{
    private final VocabularyBot vocabularyBot;
    private final VocabularyService vocabularyService;

    public InvertCommand(VocabularyBot vocabularyBot, VocabularyService vocabularyService) {
        this.vocabularyBot = vocabularyBot;
        this.vocabularyService = vocabularyService;
    }

    @Override
    public void execute(long chatId, String text) {

        UserSession session = vocabularyService.getUserSession(chatId);
        session.setCurrentVocabulary(
                session.getCurrentVocabulary().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getValue,
                                Map.Entry::getKey,
                                (existing, replacement) -> existing
                        )));

        if (session.getCurrentVocabulary() == null) {
            vocabularyBot.sendMessage(chatId, "Пожалуйста, выберите словарь перед началом теста с помощью команды /select.");
            return;
        }
        TestCommand testCommand = new TestCommand(vocabularyBot,vocabularyService);
        testCommand.execute(chatId,text);

    }
}

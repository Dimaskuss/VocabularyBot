package dmitry.example.vocabularybot.command;

import dmitry.example.vocabularybot.bot.VocabularyBot;
import dmitry.example.vocabularybot.service.VocabularyService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelectCommand implements Command {
    private final VocabularyBot vocabularyBot;
    private final VocabularyService vocabularyService;

    public SelectCommand(VocabularyBot vocabularyBot, VocabularyService vocabularyService) {
        this.vocabularyBot = vocabularyBot;
        this.vocabularyService = vocabularyService;
    }

    @Override
    public void execute(long chatId, String text) {
        List<String> dictionaryNames = new ArrayList<>(vocabularyService.getDictionaries().keySet());
        vocabularyBot.sendMessageWithOptions(chatId, "Выберите словарь:", dictionaryNames);
    }
}
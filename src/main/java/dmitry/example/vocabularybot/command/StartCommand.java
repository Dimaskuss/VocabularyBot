package dmitry.example.vocabularybot.command;

import dmitry.example.vocabularybot.bot.VocabularyBot;
import org.springframework.stereotype.Component;

@Component
public class StartCommand implements Command {
    private final VocabularyBot vocabularyBot;

    public StartCommand(VocabularyBot vocabularyBot) {
        this.vocabularyBot = vocabularyBot;
    }

    @Override
    public void execute(long chatId, String text) {
        vocabularyBot.sendMessage(chatId, "Привет дорогой друг мы здесь чтобы учить English words /test");
    }
}
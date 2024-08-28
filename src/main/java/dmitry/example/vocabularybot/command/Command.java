package dmitry.example.vocabularybot.command;

public interface Command {
    void execute(long chatId, String text);
}


package dmitry.example.vocabularybot.bot;

import dmitry.example.vocabularybot.command.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommandHandler {

    private final Map<String, Command> commands = new HashMap<>();
    @Autowired
    public CommandHandler(@Lazy InvertCommand invertCommand, @Lazy StartCommand startCommand, @Lazy TestCommand testCommand, @Lazy SelectCommand selectCommand) {
        commands.put("/start", startCommand);
        commands.put("/test", testCommand);
        commands.put("/select", selectCommand);
        commands.put("/invert",invertCommand);
    }

    public void handleCommand(long chatId, String text) {
        Command command = commands.get(text);
        if (command != null) {
            command.execute(chatId, text);
        }
    }
}

package dmitry.example.vocabularybot.bot;

import dmitry.example.vocabularybot.command.Command;
import dmitry.example.vocabularybot.command.SelectCommand;
import dmitry.example.vocabularybot.command.StartCommand;
import dmitry.example.vocabularybot.command.TestCommand;
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
    public CommandHandler(@Lazy StartCommand startCommand,@Lazy TestCommand testCommand,@Lazy SelectCommand selectCommand) {
        commands.put("/start", startCommand);
        commands.put("/test", testCommand);
        commands.put("/select", selectCommand);
        System.out.println("Вот дела , а вот и конструктор хендлера ");
    }

    public void handleCommand(long chatId, String text) {
        Command command = commands.get(text);
        if (command != null) {
            command.execute(chatId, text);
        }
    }
}

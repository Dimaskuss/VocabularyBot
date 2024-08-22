package dmitry.example.vocabularybot.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
    @Configuration
    public class BotConfig {

        @Value("${telegram.bot.token}")
        private String botToken;

        @Value("${telegram.bot.username}")
        private String botUsername;
    }


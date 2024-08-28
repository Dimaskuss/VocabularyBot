package dmitry.example.vocabularybot.service;

import dmitry.example.vocabularybot.bot.UserSession;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Data
public class VocabularyService {

    private final Map<String, Map<String, String>> dictionaries = new HashMap<>();
    private final Map<Long, UserSession> userSessions = new ConcurrentHashMap<>();



    public VocabularyService() {
        dictionaries.put("Основной", Map.ofEntries(
                Map.entry("become", "стать"),
                Map.entry("bring", "принести"),
                Map.entry("permission", "разрешение"),
                Map.entry("prediction", "предсказание"),
                Map.entry("participate", "участвовать"),
                Map.entry("intention", "намерение"),
                Map.entry("conversation", "разговор"),
                Map.entry("exhausted", "измотанный"),
                Map.entry("introduce", "представить"),
                Map.entry("delighted", "восхищенный"),
                Map.entry("mild", "мягкий"),
                Map.entry("fascinating", "увлекательный"),
                Map.entry("several", "несколько"),
                Map.entry("surgeon", "хирург"),
                Map.entry("divide", "делить"),
                Map.entry("attractive", "привлекательный"),
                Map.entry("generous", "щедрый"),
                Map.entry("wage", "заработная плата"),
                Map.entry("trainee", "стажёр"),
                Map.entry("architect", "архитектор"),
                Map.entry("urgently", "срочно"),
                Map.entry("require", "требовать"),
                Map.entry("shift", "смена"),
                Map.entry("apply for", "подавать заявление на"),
                Map.entry("addition", "дополнение"),
                Map.entry("to gain", "получить"),
                Map.entry("describe", "описать"),
                Map.entry("fabulous", "сказочный"),
                Map.entry("resign", "уволиться"),
                Map.entry("despite", "несмотря на"),
                Map.entry("promote", "продвигать"),
                Map.entry("wealthy", "богатый"),
                Map.entry("quite", "довольно"),
                Map.entry("opportunity", "возможность")
        ));
        dictionaries.put("Прилагательные 1", Map.ofEntries(
                Map.entry("big", "большой"),
                Map.entry("small", "маленький"),
                Map.entry("long", "длинный"),
                Map.entry("hot", "горячий"),
                Map.entry("cold", "холодный"),
                Map.entry("old", "старый"),
                Map.entry("new", "новый"),
                Map.entry("fast", "быстрый"),
                Map.entry("slow", "медленный"),
                Map.entry("heavy", "тяжелый"),
                Map.entry("light", "легкий"),
                Map.entry("clean", "чистый"),
                Map.entry("dirty", "грязный"),
                Map.entry("soft", "мягкий"),
                Map.entry("hard", "твердый"),
                Map.entry("bright", "яркий"),
                Map.entry("dark", "тёмный"),
                Map.entry("young", "молодой"),
                Map.entry("loud", "громкий"),
                Map.entry("quiet", "тихий"),
                Map.entry("sweet", "сладкий"),
                Map.entry("bitter", "горький"),
                Map.entry("spicy", "острый"),
                Map.entry("bland", "безвкусный"),
                Map.entry("cheap", "дешевый"),
                Map.entry("expensive", "дорогой"),
                Map.entry("full", "полный"),
                Map.entry("empty", "пустой"),
                Map.entry("rough", "грубый"),
                Map.entry("smooth", "гладкий"),
                Map.entry("modern", "современный"),
                Map.entry("simple", "простой"),
                Map.entry("complex", "сложный"),
                Map.entry("noisy", "шумный"),
                Map.entry("silent", "молчаливый"),
                Map.entry("tall", "высокий"),
                Map.entry("short", "низкий"),
                Map.entry("rich", "богатый"),
                Map.entry("poor", "бедный"),
                Map.entry("weak", "слабый"),
                Map.entry("strong", "сильный"),
                Map.entry("thick", "толстый"),
                Map.entry("thin", "тонкий"),
                Map.entry("wet", "мокрый"),
                Map.entry("dry", "сухой"),
                Map.entry("colorful", "цветной"),
                Map.entry("plain", "простой")
        ));

        dictionaries.put("Прилагательные 2", Map.ofEntries(
                Map.entry("bright", "яркий"),
                Map.entry("dark", "тёмный"),
                Map.entry("large", "большой"),
                Map.entry("small", "маленький"),
                Map.entry("quick", "быстрый"),
                Map.entry("slow", "медленный"),
                Map.entry("hot", "горячий"),
                Map.entry("cold", "холодный"),
                Map.entry("heavy", "тяжелый"),
                Map.entry("light", "легкий"),
                Map.entry("hard", "твердый"),
                Map.entry("soft", "мягкий"),
                Map.entry("clean", "чистый"),
                Map.entry("dirty", "грязный"),
                Map.entry("smooth", "гладкий"),
                Map.entry("rough", "грубый"),
                Map.entry("new", "новый"),
                Map.entry("old", "старый"),
                Map.entry("long", "длинный"),
                Map.entry("short", "короткий"),
                Map.entry("wide", "широкий"),
                Map.entry("narrow", "узкий"),
                Map.entry("empty", "пустой"),
                Map.entry("full", "полный"),
                Map.entry("strong", "сильный"),
                Map.entry("weak", "слабый"),
                Map.entry("modern", "современный"),
                Map.entry("ancient", "древний"),
                Map.entry("cheap", "дешевый"),
                Map.entry("expensive", "дорогой"),
                Map.entry("simple", "простой"),
                Map.entry("complex", "сложный"),
                Map.entry("noisy", "шумный"),
                Map.entry("silent", "молчаливый"),
                Map.entry("thick", "толстый"),
                Map.entry("thin", "тонкий"),
                Map.entry("wet", "мокрый"),
                Map.entry("dry", "сухой"),
                Map.entry("funny", "смешной"),
                Map.entry("serious", "серьезный"),
                Map.entry("colorful", "цветной"),
                Map.entry("plain", "простой"),
                Map.entry("cozy", "уютный"),
                Map.entry("spacious", "просторный")
        ));

        // Список 1: Описания человеческих состояний
        dictionaries.put("Состояния 1", Map.ofEntries(
                Map.entry("happy", "счастливый"),
                Map.entry("sad", "грустный"),
                Map.entry("angry", "злой"),
                Map.entry("tired", "уставший"),
                Map.entry("bored", "скучающий"),
                Map.entry("excited", "взволнованный"),
                Map.entry("nervous", "нервный"),
                Map.entry("calm", "спокойный"),
                Map.entry("shy", "стеснительный"),
                Map.entry("scared", "напуганный"),
                Map.entry("confident", "уверенный"),
                Map.entry("hopeful", "надеющийся"),
                Map.entry("frustrated", "раздраженный"),
                Map.entry("jealous", "ревнивый"),
                Map.entry("disappointed", "разочарованный"),
                Map.entry("proud", "гордый"),
                Map.entry("worried", "беспокоящийся"),
                Map.entry("enthusiastic", "восторженный"),
                Map.entry("guilty", "виноватый"),
                Map.entry("content", "удовлетворенный"),
                Map.entry("overwhelmed", "подавленный"),
                Map.entry("lonely", "одинокий"),
                Map.entry("relieved", "облегченный"),
                Map.entry("miserable", "несчастный"),
                Map.entry("stressed", "напряженный"),
                Map.entry("embarrassed", "смущенный"),
                Map.entry("surprised", "удивленный"),
                Map.entry("cheerful", "жизнерадостный"),
                Map.entry("eager", "жаждущий"),
                Map.entry("disgusted", "отвращенный"),
                Map.entry("regretful", "сожалеющий"),
                Map.entry("resentful", "обиженный"),
                Map.entry("insecure", "неуверенный"),
                Map.entry("apologetic", "покаянный"),
                Map.entry("cautious", "осторожный"),
                Map.entry("suspicious", "подозрительный"),
                Map.entry("confused", "сбитый с толку"),
                Map.entry("indifferent", "безразличный"),
                Map.entry("relaxed", "расслабленный"),
                Map.entry("fascinated", "очарованный"),
                Map.entry("hysterical", "истеричный"),
                Map.entry("disheartened", "потерявший надежду"),
                Map.entry("serene", "безмятежный"),
                Map.entry("empowered", "уполномоченный"),
                Map.entry("disillusioned", "разочарованный"),
                Map.entry("elated", "восторженный"),
                Map.entry("sorrowful", "печальный"),
                Map.entry("humiliated", "униженный")
        ));

        // Список 2: Дополнительные описания человеческих состояний
        dictionaries.put("Состояния 2", Map.ofEntries(
                Map.entry("irritated", "раздраженный"),
                Map.entry("frightened", "испуганный"),
                Map.entry("annoyed", "раздраженный"),
                Map.entry("exhausted", "измотанный"),
                Map.entry("pessimistic", "пессимистичный"),
                Map.entry("optimistic", "оптимистичный"),
                Map.entry("curious", "любопытный"),
                Map.entry("regretful", "сожалеющий"),
                Map.entry("resentful", "обиженный"),
                Map.entry("insecure", "неуверенный"),
                Map.entry("embarrassed", "смущенный"),
                Map.entry("surprised", "удивленный"),
                Map.entry("cheerful", "жизнерадостный"),
                Map.entry("puzzled", "озадаченный"),
                Map.entry("hopeful", "надеющийся"),
                Map.entry("nervous", "нервный"),
                Map.entry("disheartened", "потерявший надежду"),
                Map.entry("resigned", "смирившийся"),
                Map.entry("touched", "трогательный"),
                Map.entry("afraid", "боящийся"),
                Map.entry("bored", "скучающий"),
                Map.entry("excited", "взволнованный"),
                Map.entry("grateful", "благодарный"),
                Map.entry("inspired", "вдохновленный"),
                Map.entry("guilty", "виноватый"),
                Map.entry("content", "довольный"),
                Map.entry("relieved", "облегченный"),
                Map.entry("anxious", "тревожный"),
                Map.entry("fascinated", "очарованный"),
                Map.entry("disillusioned", "разочарованный"),
                Map.entry("overjoyed", "вне себя от радости"),
                Map.entry("dismayed", "пораженный"),
                Map.entry("alarmed", "тревожный"),
                Map.entry("conflicted", "в конфликте"),
                Map.entry("grief-stricken", "опечаленный"),
                Map.entry("jaded", "измотанный"),
                Map.entry("numb", "онемевший"),
                Map.entry("humiliated", "униженный"),
                Map.entry("invigorated", "ободренный"),
                Map.entry("apprehensive", "опасающийся"),
                Map.entry("saddened", "опечаленный"),
                Map.entry("discontented", "недовольный"),
                Map.entry("horrified", "ужаснутый"),
                Map.entry("incredulous", "недоверчивый")
        ));

    }

    public UserSession getUserSession(long chatId) {
        return userSessions.computeIfAbsent(chatId, id -> new UserSession());
    }


    public void selectDictionary(String dictionaryName, long chatId) {
        if (dictionaries.containsKey(dictionaryName)) {
            UserSession session = getUserSession(chatId);
            session.setCurrentVocabulary(dictionaries.get(dictionaryName));
            session.clear();
        } else {
            throw new IllegalArgumentException("Словарь с таким именем не найден: " + dictionaryName);
        }
    }

    public Map<String, String> getUserCurrentVocabulary(long chatId) {
        UserSession session = getUserSession(chatId);
        if (session.getCurrentVocabulary() == null) {
            throw new IllegalStateException("Текущий словарь для пользователя не установлен.");
        }
        return session.getCurrentVocabulary();
    }


    public String getNextWordToCheck(long chatId) {
        Map<String, String> currentVocabulary = getUserCurrentVocabulary(chatId);
        if (currentVocabulary == null) {
            throw new IllegalStateException("Словарь не выбран или не установлен для пользователя.");
        }
        UserSession session = getUserSession(chatId);
        return getUserCurrentVocabulary(chatId).keySet().stream()
                .filter(word -> !session.getCheckedWords().contains(word))
                .findFirst()
                .orElse(null);
    }

    public List<String> generateOptions(long chatId,String word) {
        List<String> values = new ArrayList<>(getUserCurrentVocabulary(chatId).values());
        String correctAnswer = getUserCurrentVocabulary(chatId).get(word);
        values.remove(correctAnswer);
        Collections.shuffle(values);

        List<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.add(values.get(0));
        options.add(values.get(1));
        Collections.shuffle(options);

        return options;
    }

    public void markWordAsChecked(long chatId, String word) {
        getUserSession(chatId).getCheckedWords().add(word);
    }

    public boolean isCorrectAnswer(long chatId, String word, String answer) {
        return getUserCurrentVocabulary(chatId).get(word).equals(answer);
    }

    public void incrementCounter(long chatId) {
        getUserSession(chatId).incrementCounter();
    }

    public int getCounter(long chatId) {
        return getUserSession(chatId).getCounter();
    }
}


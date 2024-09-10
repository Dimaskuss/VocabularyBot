package dmitry.example.vocabularybot.service;

import dmitry.example.vocabularybot.bot.UserSession;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
        dictionaries.put("A-E edjIT", Map.ofEntries(
                Map.entry("accessible", "доступный"),
                Map.entry("accurate", "точный"),
                Map.entry("active", "активный"),
                Map.entry("adaptable", "адаптируемый"),
                Map.entry("advanced", "продвинутый"),
                Map.entry("affordable", "доступный по цене"),
                Map.entry("agile", "гибкий"),
                Map.entry("aligned", "согласованный"),
                Map.entry("ambitious", "амбициозный"),
                Map.entry("analytical", "аналитический"),
                Map.entry("automated", "автоматизированный"),
                Map.entry("available", "доступный"),
                Map.entry("balanced", "сбалансированный"),
                Map.entry("beneficial", "выгодный"),
                Map.entry("broad", "широкий"),
                Map.entry("centralized", "централизованный"),
                Map.entry("challenging", "сложный"),
                Map.entry("clear", "ясный"),
                Map.entry("collaborative", "совместный"),
                Map.entry("comparable", "сравнимый"),
                Map.entry("compatible", "совместимый"),
                Map.entry("comprehensive", "всесторонний"),
                Map.entry("confidential", "конфиденциальный"),
                Map.entry("consistent", "последовательный"),
                Map.entry("constructive", "конструктивный"),
                Map.entry("continuous", "непрерывный"),
                Map.entry("cost-effective", "экономичный"),
                Map.entry("creative", "креативный"),
                Map.entry("critical", "критический"),
                Map.entry("customizable", "настраиваемый"),
                Map.entry("cutting-edge", "передовой"),
                Map.entry("dedicated", "преданный"),
                Map.entry("dependable", "надежный"),
                Map.entry("detailed", "детальный"),
                Map.entry("digital", "цифровой"),
                Map.entry("direct", "прямой"),
                Map.entry("distributed", "распределенный"),
                Map.entry("dynamic", "динамичный")
        ));
        dictionaries.put("E-I adjIT", Map.ofEntries(
                Map.entry("efficient", "эффективный"),
                Map.entry("emerging", "зарождающийся"),
                Map.entry("empowered", "уполномоченный"),
                Map.entry("enriched", "обогащенный"),
                Map.entry("essential", "необходимый"),
                Map.entry("established", "установленный"),
                Map.entry("ethical", "этичный"),
                Map.entry("evolving", "развивающийся"),
                Map.entry("exceptional", "исключительный"),
                Map.entry("exclusive", "эксклюзивный"),
                Map.entry("expanding", "расширяющийся"),
                Map.entry("experienced", "опытный"),
                Map.entry("experimental", "экспериментальный"),
                Map.entry("explicit", "явный"),
                Map.entry("extended", "расширенный"),
                Map.entry("extensive", "обширный"),
                Map.entry("external", "внешний"),
                Map.entry("fast-growing", "быстрорастущий"),
                Map.entry("feasible", "осуществимый"),
                Map.entry("flexible", "гибкий"),
                Map.entry("focused", "сфокусированный"),
                Map.entry("formal", "формальный"),
                Map.entry("foundational", "основополагающий"),
                Map.entry("frequent", "частый"),
                Map.entry("functional", "функциональный"),
                Map.entry("global", "глобальный"),
                Map.entry("goal-oriented", "целевый"),
                Map.entry("high-performance", "высокопроизводительный"),
                Map.entry("holistic", "целостный"),
                Map.entry("immediate", "немедленный"),
                Map.entry("impactful", "действенный"),
                Map.entry("important", "важный"),
                Map.entry("in-depth", "углубленный"),
                Map.entry("inclusive", "включающий"),
                Map.entry("independent", "независимый"),
                Map.entry("innovative", "инновационный"),
                Map.entry("integrated", "интегрированный"),
                Map.entry("intelligent", "интеллектуальный"),
                Map.entry("interactive", "интерактивный"),
                Map.entry("interconnected", "взаимосвязанный"),
                Map.entry("interdisciplinary", "междисциплинарный"),
                Map.entry("internal", "внутренний"),
                Map.entry("interoperable", "взаимодействующий"),
                Map.entry("intuitive", "интуитивный"),
                Map.entry("invaluable", "бесценный")
        ));
        dictionaries.put("K-O adjIT", Map.ofEntries(
                Map.entry("key", "ключевой"),
                Map.entry("large-scale", "крупномасштабный"),
                Map.entry("leading", "ведущий"),
                Map.entry("legacy", "устаревший"),
                Map.entry("lightweight", "легковесный"),
                Map.entry("logical", "логичный"),
                Map.entry("long-term", "долгосрочный"),
                Map.entry("low-cost", "недорогой"),
                Map.entry("mature", "зрелый"),
                Map.entry("measurable", "измеримый"),
                Map.entry("mission-critical", "жизненно важный"),
                Map.entry("mobile", "мобильный"),
                Map.entry("modern", "современный"),
                Map.entry("modular", "модульный"),
                Map.entry("multi-layered", "многослойный"),
                Map.entry("multi-platform", "мультиплатформенный"),
                Map.entry("multi-tiered", "многоуровневый"),
                Map.entry("native", "встроенный"),
                Map.entry("next-generation", "следующего поколения"),
                Map.entry("novel", "новый"),
                Map.entry("numerous", "многочисленный"),
                Map.entry("objective", "объективный"),
                Map.entry("on-demand", "по запросу"),
                Map.entry("on-premises", "локальный"),
                Map.entry("open", "открытый"),
                Map.entry("optimal", "оптимальный"),
                Map.entry("outdated", "устаревший"),
                Map.entry("out-of-the-box", "готовый к использованию"),
                Map.entry("outstanding", "выдающийся"),
                Map.entry("overarching", "всеобъемлющий")
        ));
        dictionaries.put("P-R adjIT", Map.ofEntries(
                Map.entry("parallel", "параллельный"),
                Map.entry("participant-driven", "участие ориентированное"),
                Map.entry("patient-centric", "ориентированный на пациента"),
                Map.entry("perceived", "воспринимаемый"),
                Map.entry("persistent", "постоянный"),
                Map.entry("personalized", "персонализированный"),
                Map.entry("pioneering", "новаторский"),
                Map.entry("portable", "переносной"),
                Map.entry("positive", "положительный"),
                Map.entry("practical", "практический"),
                Map.entry("precise", "точный"),
                Map.entry("predictable", "предсказуемый"),
                Map.entry("preferable", "предпочтительный"),
                Map.entry("preliminary", "предварительный"),
                Map.entry("premier", "первоклассный"),
                Map.entry("primary", "основной"),
                Map.entry("productive", "продуктивный"),
                Map.entry("proficient", "умелый"),
                Map.entry("progressive", "прогрессивный"),
                Map.entry("prominent", "видный"),
                Map.entry("proven", "проверенный"),
                Map.entry("qualified", "квалифицированный"),
                Map.entry("rapid", "быстрый"),
                Map.entry("reliable", "надежный"),
                Map.entry("relevant", "актуальный"),
                Map.entry("remarkable", "замечательный"),
                Map.entry("remote", "удаленный"),
                Map.entry("repeatable", "повторяемый"),
                Map.entry("reputable", "уважаемый"),
                Map.entry("resilient", "устойчивый"),
                Map.entry("resourceful", "находчивый"),
                Map.entry("responsive", "отзывчивый"),
                Map.entry("robust", "прочный")
        ));
        dictionaries.put("S-W adjIT", Map.ofEntries(
                Map.entry("scalable", "масштабируемый"),
                Map.entry("seamless", "бесшовный"),
                Map.entry("secure", "безопасный"),
                Map.entry("self-sufficient", "самодостаточный"),
                Map.entry("sensible", "разумный"),
                Map.entry("sequential", "последовательный"),
                Map.entry("significant", "значительный"),
                Map.entry("simple", "простой"),
                Map.entry("skilled", "опытный"),
                Map.entry("smart", "умный"),
                Map.entry("sophisticated", "сложный"),
                Map.entry("specialized", "специализированный"),
                Map.entry("stable", "стабильный"),
                Map.entry("standardized", "стандартизированный"),
                Map.entry("strategic", "стратегический"),
                Map.entry("streamlined", "оптимизированный"),
                Map.entry("structured", "структурированный"),
                Map.entry("substantial", "существенный"),
                Map.entry("successful", "успешный"),
                Map.entry("suitable", "подходящий"),
                Map.entry("sustainable", "устойчивый"),
                Map.entry("swift", "быстрый"),
                Map.entry("tailored", "адаптированный"),
                Map.entry("targeted", "целевой"),
                Map.entry("technical", "технический"),
                Map.entry("timely", "своевременный"),
                Map.entry("top-tier", "первоклассный"),
                Map.entry("transparent", "прозрачный"),
                Map.entry("unified", "объединенный"),
                Map.entry("unique", "уникальный"),
                Map.entry("universal", "универсальный"),
                Map.entry("up-to-date", "актуальный"),
                Map.entry("usable", "пригодный к использованию"),
                Map.entry("useful", "полезный"),
                Map.entry("user-centric", "ориентированный на пользователя"),
                Map.entry("user-friendly", "удобный для пользователя"),
                Map.entry("valuable", "ценный"),
                Map.entry("versatile", "универсальный"),
                Map.entry("visible", "видимый"),
                Map.entry("vital", "жизненно важный"),
                Map.entry("wide-ranging", "широкомасштабный"),
                Map.entry("wireless", "беспроводной"),
                Map.entry("worthwhile", "стоящий")
        ));
        dictionaries.put("A-D IT words", Map.ofEntries(
                Map.entry("allocation", "распределение"),
                Map.entry("annotation", "аннотация"),
                Map.entry("application", "приложение"),
                Map.entry("array", "массив"),
                Map.entry("assertion", "утверждение"),
                Map.entry("assignment", "присваивание"),
                Map.entry("asynchronous", "асинхронный"),
                Map.entry("authorization", "авторизация"),
                Map.entry("binary", "двоичный"),
                Map.entry("binding", "связывание"),
                Map.entry("buffer", "буфер"),
                Map.entry("casting", "приведение типов"),
                Map.entry("chaining", "сцепление"),
                Map.entry("character", "символ"),
                Map.entry("class", "класс"),
                Map.entry("cloning", "клонирование"),
                Map.entry("collection", "коллекция"),
                Map.entry("compatibility", "совместимость"),
                Map.entry("computation", "вычисление"),
                Map.entry("concurrency", "параллелизм"),
                Map.entry("configuration", "конфигурация"),
                Map.entry("connection", "соединение"),
                Map.entry("constraint", "ограничение"),
                Map.entry("container", "контейнер"),
                Map.entry("context", "контекст"),
                Map.entry("controller", "контроллер"),
                Map.entry("conversion", "преобразование"),
                Map.entry("corruption", "повреждение"),
                Map.entry("coverage", "покрытие"),
                Map.entry("customization", "настройка"),
                Map.entry("debugging", "отладка"),
                Map.entry("decoding", "декодирование"),
                Map.entry("decryption", "расшифровка"),
                Map.entry("delegation", "делегирование"),
                Map.entry("dependency", "зависимость"),
                Map.entry("deprecation", "устаревание"),
                Map.entry("descriptor", "дескриптор"),
                Map.entry("dimension", "размерность"),
                Map.entry("directory", "каталог"),
                Map.entry("dispatch", "отправка"),
                Map.entry("distribution", "распределение"),
                Map.entry("dynamic", "динамический")
        ));
        dictionaries.put("E-M IT words", Map.ofEntries(
                Map.entry("efficient", "эффективный"),
                Map.entry("emulation", "эмуляция"),
                Map.entry("environment", "среда"),
                Map.entry("equality", "равенство"),
                Map.entry("evaluation", "оценка"),
                Map.entry("extension", "расширение"),
                Map.entry("fallback", "резервный"),
                Map.entry("field", "поле"),
                Map.entry("floating", "плавающий"),
                Map.entry("flush", "сброс"),
                Map.entry("fragment", "фрагмент"),
                Map.entry("garbage", "мусор"),
                Map.entry("generic", "обобщенный"),
                Map.entry("grouping", "группировка"),
                Map.entry("hashing", "хеширование"),
                Map.entry("holder", "хранитель"),
                Map.entry("identifier", "идентификатор"),
                Map.entry("immutable", "неизменяемый"),
                Map.entry("import", "импорт"),
                Map.entry("increment", "увеличение"),
                Map.entry("indirection", "опосредование"),
                Map.entry("injection", "внедрение"),
                Map.entry("inlining", "встраивание"),
                Map.entry("instance", "экземпляр"),
                Map.entry("integrity", "целостность"),
                Map.entry("interceptor", "перехватчик"),
                Map.entry("invocation", "вызов"),
                Map.entry("iteration", "итерация"),
                Map.entry("keyword", "ключевое слово"),
                Map.entry("layout", "макет"),
                Map.entry("leak", "утечка"),
                Map.entry("literal", "буквальный"),
                Map.entry("locale", "локаль"),
                Map.entry("locking", "блокировка"),
                Map.entry("lookup", "поиск"),
                Map.entry("marshal", "выстраивать"),
                Map.entry("modular", "модульный"),
                Map.entry("modifier", "модификатор"),
                Map.entry("mount", "монтировать")
        ));
        dictionaries.put("N-S IT words", Map.ofEntries(
                Map.entry("namespace", "пространство имен"),
                Map.entry("node", "узел"),
                Map.entry("notification", "уведомление"),
                Map.entry("object", "объект"),
                Map.entry("operand", "операнд"),
                Map.entry("overhead", "накладные расходы"),
                Map.entry("padding", "заполнение"),
                Map.entry("parsing", "разбор"),
                Map.entry("persistence", "сохранение"),
                Map.entry("pixel", "пиксель"),
                Map.entry("placeholder", "заместитель"),
                Map.entry("predicate", "предикат"),
                Map.entry("precision", "точность"),
                Map.entry("processing", "обработка"),
                Map.entry("profiling", "профилирование"),
                Map.entry("property", "свойство"),
                Map.entry("random", "случайный"),
                Map.entry("reallocation", "перераспределение"),
                Map.entry("recursion", "рекурсия"),
                Map.entry("reference", "ссылка"),
                Map.entry("refinement", "уточнение"),
                Map.entry("reflection", "рефлексия"),
                Map.entry("resource", "ресурс"),
                Map.entry("responsive", "отзывчивый"),  // Новое слово
                Map.entry("return", "возврат"),
                Map.entry("rollback", "откат"),
                Map.entry("robust", "прочный"),  // Новое слово
                Map.entry("scalable", "масштабируемый"),  // Новое слово
                Map.entry("scope", "область видимости"),
                Map.entry("secure", "безопасный"),  // Новое слово
                Map.entry("sequence", "последовательность"),
                Map.entry("shadowing", "затенение"),
                Map.entry("shell", "оболочка"),
                Map.entry("simple", "простой"),  // Новое слово
                Map.entry("snapshot", "снимок"),
                Map.entry("spacing", "интервал"),
                Map.entry("stacktrace", "трассировка стека"),
                Map.entry("stable", "стабильный"),  // Новое слово
                Map.entry("state", "состояние"),
                Map.entry("string", "строка"),
                Map.entry("structure", "структура"),
                Map.entry("subsystem", "подсистема"),
                Map.entry("surrogate", "заменитель"),
                Map.entry("synchronized", "синхронизированный"),  // Новое слово
                Map.entry("syntax", "синтаксис"),
                Map.entry("system", "система")
        ));
        dictionaries.put("T-W IT words", Map.ofEntries(
                Map.entry("termination", "завершение"),
                Map.entry("threading", "многопоточность"),
                Map.entry("token", "токен"),
                Map.entry("traversal", "обход"),
                Map.entry("typing", "типизация"),
                Map.entry("unboxing", "распаковка"),
                Map.entry("unicode", "Unicode"),
                Map.entry("unique", "уникальный"),  // Новое слово
                Map.entry("unroll", "развертывание"),
                Map.entry("validation", "валидация"),
                Map.entry("variable", "переменная"),
                Map.entry("version", "версия"),
                Map.entry("viewport", "окно просмотра"),
                Map.entry("virtual", "виртуальный"),
                Map.entry("volatile", "нестабильный"),
                Map.entry("whitespace", "пробелы"),
                Map.entry("wrapper", "обертка")
        ));

    }

    public UserSession getUserSession(long chatId) {
        return userSessions.computeIfAbsent(chatId, id -> new UserSession());
    }


    public void selectDictionary(String dictionaryName, long chatId) {
        if (dictionaries.containsKey(dictionaryName)) {
            UserSession session = getUserSession(chatId);
            session.setCurrentVocabulary(dictionaries.get(dictionaryName));
            session.clearSessionFields();
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

    public List<String> generateOptions(long chatId, String word) {
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

//    public String getNextInvertWordToCheck(long chatId) {
//        Map<String, String> currentVocabulary = getUserCurrentVocabulary(chatId).entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getValue,
//                        Map.Entry::getKey,
//                        (existing, replacement) -> existing
//                ));
//        if (currentVocabulary == null) {
//            throw new IllegalStateException("Словарь не выбран или не установлен для пользователя.");
//        }
//        UserSession session = getUserSession(chatId);
//        return currentVocabulary.keySet().stream()
//                .filter(word -> !session.getCheckedWords().contains(word))
//                .findFirst()
//                .orElse(null);
//
//    }
//
//    public List<String> generateInvertOptions(long chatId, String word) {
//        Map<String, String> invertCurrentVocabulary = new HashMap<>(getUserCurrentVocabulary(chatId).entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getValue,
//                        Map.Entry::getKey,
//                        (existing, replacement) -> existing
//                )));
//        List<String> values = new ArrayList<>(invertCurrentVocabulary.values());
//        String correctAnswer = getUserCurrentVocabulary(chatId).get(word);
//        values.remove(correctAnswer);
//        Collections.shuffle(values);
//
//        List<String> options = new ArrayList<>();
//        options.add(correctAnswer);
//        options.add(values.get(0));
//        options.add(values.get(1));
//        Collections.shuffle(options);
//
//        return options;
//    }

}


package dmitry.example.vocabularybot.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class VocabularyService {

    private Map<String, String> vocabulary ;
    private final Set<String> checkedWords = new HashSet<>();
    private String currentWord;

    private int counter;

    public VocabularyService() {
        this.vocabulary =  Map.ofEntries(
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
        );
    }

    public String getNextWordToCheck() {
        return vocabulary.keySet().stream()
                .filter(word -> !checkedWords.contains(word))
                .findFirst()
                .orElse(null);
    }

    public List<String> generateOptions(String word) {
        List<String> values = new ArrayList<>(vocabulary.values());
        String correctAnswer = vocabulary.get(word);
        values.remove(correctAnswer);
        Collections.shuffle(values);

        List<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.add(values.get(0));
        options.add(values.get(1));
        Collections.shuffle(options);

        return options;
    }

    public void markWordAsChecked(String word) {
        checkedWords.add(word);
    }

    public void clearCheckedWordsAndCounter(){
        checkedWords.clear();
        setCounter(0);
    }

    public boolean isCorrectAnswer(String word, String answer) {
        return vocabulary.get(word).equals(answer);
    }

    public int Increment(int counter) {
        return ++counter;
    }
}


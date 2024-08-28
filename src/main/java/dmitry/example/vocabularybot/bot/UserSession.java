package dmitry.example.vocabularybot.bot;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserSession {
    private final Set<String> checkedWords = new HashSet<>();
    private String currentWord;
    private int counter;
    private Map<String, String> currentVocabulary;

    public Map<String, String> getCurrentVocabulary() {
        return currentVocabulary;
    }

    public void setCurrentVocabulary(Map<String, String> currentVocabulary) {
        this.currentVocabulary = currentVocabulary;
    }

    public Set<String> getCheckedWords() {
        return checkedWords;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public void clear() {
        checkedWords.clear();
        counter = 0;
        currentWord = null;
    }
}
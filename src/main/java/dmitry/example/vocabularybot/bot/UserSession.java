package dmitry.example.vocabularybot.bot;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class UserSession {
    private final Set<String> checkedWords = new HashSet<>();
    private String currentWord;
    private int counter;
    private Map<String, String> currentVocabulary = new HashMap<>();
    private final Map<String, String> wrongAnswers = new HashMap<>();


    public Map<String, String> getWrongAnswers() {
        return wrongAnswers;
    }

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

    public void clearSessionFields() {
        checkedWords.clear();
        counter = 0;
        currentWord = null;
        wrongAnswers.clear();
    }
}
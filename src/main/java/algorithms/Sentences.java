package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (!(sentence.endsWith("!") || sentence.endsWith("?") || sentence.endsWith("."))) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        if (sentence.charAt(0) < 65 || sentence.charAt(0) >90) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        sentences.add(sentence);
    }

    public String findLongestSentence() {
        if (sentences.size() == 0) {
            throw new IllegalStateException("There is no sentence in the list!");
        }
        String result = "";
        int length = 0;
        for (String s : sentences) {
            if (s.length() > length) {
                length = s.length();
                result = s;
            }
        }
        return result;
    }

    public List<String> getSentences() {
        return sentences;
    }
}

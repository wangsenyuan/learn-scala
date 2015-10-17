package unique.word.abbreviation.p288;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by senyuanwang on 15/10/6.
 */
public class ValidWordAbbr {
    private Map<String, List<String>> abbr;

    public ValidWordAbbr(String[] dictionary) {
        abbr = new HashMap<>();

        for (String word : dictionary) {
            String pattern = getPattern(word);
            if (!abbr.containsKey(pattern)) {
                abbr.put(pattern, new ArrayList<>());
            }
            abbr.get(pattern).add(word);
        }
    }

    private String getPattern(String word) {
        if (word.length() <= 2) {
            return word;
        }

        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);

        return "" + first + (word.length() - 2) + last;
    }

    public boolean isUnique(String word) {
        String pattern = getPattern(word);
        List<String> words = abbr.get(pattern);
        if (words == null) {
            return true;
        }

        if (words.size() > 1) {
            return false;
        }

        String theWord = words.get(0);

        return theWord.equals(word);
    }
}
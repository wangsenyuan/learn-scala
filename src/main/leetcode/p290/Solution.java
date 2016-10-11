package p290;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/10/6.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<>();
        Map<Character, String> reverse = new HashMap<>();
        String[] words = str.split("\\s+");
        char[] cs = pattern.toCharArray();
        if (words.length != cs.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = cs[i];
            if (!map.containsKey(word) && !reverse.containsKey(c)) {
                map.put(word, c);
                reverse.put(c, word);
            }

            if (!map.containsKey(word) || !reverse.containsKey(c)) {
                return false;
            }

            if (c != map.get(word) || !word.equals(reverse.get(c))) {
                return false;
            }
        }

        return true;
    }
}

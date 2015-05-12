package p205.isomorphic.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/4/29.
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        int i = 0;
        Map<Character, Integer> xs = new HashMap<>();
        Map<Character, Integer> ys = new HashMap<>();
        for (; i < s.length() && i < t.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);

            if (!xs.containsKey(x)) {
                xs.put(x, i);
            }

            if (!ys.containsKey(y)) {
                ys.put(y, i);
            }

            int xi = xs.get(x);
            int yi = ys.get(y);
            if (xi != yi) {
                break;
            }
        }

        if (i < s.length() || i < t.length()) {
            return false;
        }

        return true;
    }
}

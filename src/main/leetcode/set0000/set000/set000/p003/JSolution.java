package set0000.set000.set000.p003;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 6/15/16.
 */
public class JSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] cs = s.toCharArray();
        Map<Character, Integer> prev = new HashMap<>();

        int res = 1;
        for (int i = 0, j = 0; j < cs.length; j++) {
            char c = cs[j];
            Integer k = prev.get(c);
            if (k != null && k >= i) {
                i = k + 1;
            }

            prev.put(c, j);
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        JSolution solution = new JSolution();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));

        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));

    }
}

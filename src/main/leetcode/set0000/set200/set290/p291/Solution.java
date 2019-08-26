package set0000.set200.set290.p291;

import java.util.HashSet;

/**
 * Created by wangsenyuan on 07/10/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPatternMatch("abab", "redblueredblue"));
    }

    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(pattern.toCharArray(), 0, str.toCharArray(), 0, new String[26], new HashSet<>());
    }

    public boolean isMatch(char[] pattern, int p, char[] str, int s, String[] map, HashSet<String> visitSet) {
        if (p > pattern.length - 1 && s > str.length - 1) {
            return true;
        }
        if (p > pattern.length - 1 || s > str.length - 1) {
            return false;
        }

        if (map[pattern[p] - 'a'] == null) {
            // -----------------------------I added these 4 lines--------------------------
            int endPoint = str.length - 1;
            for (int i = pattern.length - 1; i > p; i--) {
                endPoint -= map[pattern[i] - 'a'] == null ? 1 : map[pattern[i] - 'a'].length();
            }
            //-----------------------------------------------------------------------------------
            for (int i = s; i <= endPoint; ++i) {
                String ts = new String(str, s, i - s + 1);
                if (visitSet.contains(ts)) {
                    continue;
                }
                map[pattern[p] - 'a'] = ts;
                visitSet.add(ts);
                if (isMatch(pattern, p + 1, str, i + 1, map, visitSet)) {
                    return true;
                }
                map[pattern[p] - 'a'] = null;
                visitSet.remove(ts);
            }

            return false;
        }

        String vString = map[pattern[p] - 'a'];
        if (s + vString.length() > str.length) {
            return false;
        }
        String ts = new String(str, s, vString.length());
        if (vString.equals(ts)) {
            return isMatch(pattern, p + 1, str, s + vString.length(), map, visitSet);
        }

        return false;
    }
}

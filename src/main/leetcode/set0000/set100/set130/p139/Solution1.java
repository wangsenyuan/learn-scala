package set0000.set100.set130.p139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 16/8/20.
 */
public class Solution1 {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        Solution1 solution = new Solution1();
        String s = "leetcode";
        System.out.println(solution.wordBreak(s, dict));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;

        for (String word : wordDict) {
            if (word.length() < minLen) {
                minLen = word.length();
            }

            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        char[] cs = s.toCharArray();
        int n = s.length();

        boolean[] canBreak = new boolean[n + 1];
        canBreak[0] = true;
        for (int i = minLen; i <= n; i++) {
            for (int k = minLen; i - k >= 0 && k <= maxLen && !canBreak[i]; k++) {
                int j = i - k;
                canBreak[i] = canBreak[j] && wordDict.contains(new String(cs, j, k));
            }
        }

        return canBreak[n];
    }
}

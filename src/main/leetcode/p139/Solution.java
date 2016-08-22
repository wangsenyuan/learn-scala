package p139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangsenyuan on 8/20/16.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        System.out.println(solution.wordBreak("leetxcode", dict));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        char[] cs = s.toCharArray();
        int[] checked = new int[cs.length];
        return wordBreak(cs, 0, checked, wordDict);
    }

    private boolean wordBreak(char[] cs, int i, int[] checked, Set<String> wordDict) {
        if (i == cs.length) {
            return true;
        }

        if (checked[i] != 0) {
            return checked[i] == 1;
        }

        for (int j = i + 1; j <= cs.length; j++) {
            if (wordDict.contains(new String(cs, i, j - i)) && wordBreak(cs, j, checked, wordDict)) {
                checked[i] = 1;
                return true;
            }
        }

        checked[i] = -1;
        return false;
    }
}

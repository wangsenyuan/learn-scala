package palindrom.permutation.p266;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }

        int oddChar = 0;
        for (char c : counts.keySet()) {
            int v = counts.get(c);
            if (v % 2 == 0) {
                continue;
            }
            oddChar += 1;
            if (oddChar > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("as"));
    }
}

package set200.set260.p266;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        boolean odd = false;
        for (int cnt : counts.values()) {
            if (cnt % 2 == 1) {
                if (!odd) {
                    odd = true;
                } else {
                    return false;
                }
            }
        }

        return (s.length() % 2 == 1 && odd) || !odd;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("as"));
    }
}

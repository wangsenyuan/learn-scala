package p340.longest.substr.with.atmostk.distict.chars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 4/3/16.
 */
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int startAt = 0;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, 1 + count);
                maxLen = Math.max(maxLen, i - startAt + 1);
                continue;
            }

            map.put(c, 1);
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, i - startAt + 1);
                continue;
            }

            for (int j = startAt; j <= i && map.size() > k; j++) {
                int countOfCharAtJ = map.get(chars[j]);
                if (countOfCharAtJ == 1) {
                    map.remove(chars[j]);
                } else {
                    map.put(chars[j], countOfCharAtJ - 1);
                }
                startAt = j + 1;
            }
            maxLen = Math.max(maxLen, i - startAt + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("bacc", 2));
    }
}

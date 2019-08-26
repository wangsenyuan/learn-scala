package set0000.set100.set150.p159;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        return lengthOfLongestSubstringTwoDistinct(s.toCharArray());
    }

    public static int lengthOfLongestSubstringTwoDistinct(char[] cs) {
        int n = cs.length;
        int i = 0; // slow pointer
        int j = 0; // fast pointer
        int max = 0;

        // use a map to track the char and its count
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while (j < n) {
            char ch = cs[j];

            if (map.size() < 2 || map.containsKey(ch)) {
                // less than 2 distinct chars or the char is in the map already
                // put it to the map and update the count
                map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);

                // update the max
                max = Math.max(max, ++j - i);
            } else {
                // we keep removing the old chars from the map
                // till we only have one distinct char
                while (map.size() == 2) {
                    ch = cs[i++];

                    if (map.get(ch) > 1)
                        map.put(ch, map.get(ch) - 1);
                    else
                        map.remove(ch);
                }
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstringTwoDistinct1(char[] cs) {
        int res = 0;
        for (int i = 0; i < cs.length; ) {
            int j = i + 1;
            while (j < cs.length && cs[j] == cs[i]) {
                j++;
            }
            int k = j;
            while (k < cs.length && (cs[k] == cs[i] || cs[k] == cs[j])) {
                k++;
            }
            if (k - i > res) {
                res = k - i;
            }
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abacd"));
    }
}

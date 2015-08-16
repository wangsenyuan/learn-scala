package p159.longest.substr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        int i = 0, j = 0, k = 0, n = cs.length;
        int res = 0;

        while (j < n && k < n) {
            j = i + 1;
            while (j < n && cs[j] == cs[i]) {
                j++;
            }

            if (j == n) {
                res = Math.max(res, j - i);
                break;
            }

            k = j + 1;
            while (k < n && (cs[k] == cs[i] || cs[k] == cs[j])) {
                k++;
            }
            res = Math.max(res, k - i);
            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abacd"));
    }
}

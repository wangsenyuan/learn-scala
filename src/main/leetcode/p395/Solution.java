package p395;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 16/9/4.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("aaabb", 3));
        System.out.println(solution.longestSubstring("ababbc", 2));
    }

    public int longestSubstring(String s, int k) {
        return findSub(s.toCharArray(), 0, s.length(), k, new HashMap<>());
    }

    private int findSub(char[] cs, int from, int end, int k, Map<Integer, Integer> cache) {
        return cache.computeIfAbsent(from, (Integer fromx) -> {
            if (end - from < k) {
                return 0;
            }

            Map<Character, Integer> cnts = new HashMap<>();

            for (int i = from; i < end; i++) {
                cnts.put(cs[i], cnts.getOrDefault(cs[i], 0) + 1);
            }

            int res = 0;
            int j = from;
            for (int i = from; i < end; i++) {
                if (cnts.get(cs[i]) < k) {
                    int subRes = findSub(cs, j, i, k, cache);
                    if (subRes > res) {
                        res = subRes;
                    }
                    j = i + 1;
                }
            }

            if (j == from) {
                res = end - from;
            } else if (j < end) {
                int subRes = findSub(cs, j, end, k, cache);
                if (subRes > res) {
                    res = subRes;
                }
            }

            return res;
        });

    }
}

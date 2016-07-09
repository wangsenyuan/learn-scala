package p030.substring.with.concatenation.of.all.words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsenyuan on 1/2/16.
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        /**
         * Let n=s.length, k=words[0].length traverse s with indices i, i+k,
         * i+2k, ... for 0<=i<k, so that the time complexity is O(n).
         */
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = words.length;
        if (n == 0 || m == 0 || (words[0].length()) == 0) {
            return res;
        }

        int k = words[0].length();

        Map<String, Integer> wDict = new HashMap<>();

        for (String word : words) {
            wDict.put(word, wDict.getOrDefault(word, 0) + 1);
        }

        int wordsLen = m * k;
        Map<String, Integer> tmp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            tmp.clear();
            int start = i;
            for (int j = i; j + k <= n && start + wordsLen <= n; j += k) {
                String test = s.substring(j, j + k);
                if (!wDict.containsKey(test)) {
                    start = j + k;
                    tmp.clear();
                    continue;
                }
                for (int a = start; tmp.get(test) == wDict.get(test); a += k) {
                    start += k;
                    String b = s.substring(a, a + k);
                    tmp.put(b, tmp.get(b) - 1);
                }
                if (start + wordsLen == j + k) {
                    res.add(start);
                }
                tmp.put(test, tmp.getOrDefault(test, 0) + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"foo", "bar", "the"};
        List<Integer> result = solution.findSubstring("barfoofoobarthefoobarman", words);
        System.out.println(result);
    }
}

package substring.with.concatenation.of.all.words.p030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        HashMap<String, Integer> wDict = new HashMap<>();

        for (String word : words) {
            wDict.put(word, wDict.getOrDefault(word, 0) + 1);
        }

        int wordsLen = m * k;
        HashMap<String, Integer> curDict = new HashMap<>();

        for (int i = 0; i < k; i++) {
            curDict.clear();
            int start = i;
            if (start + wordsLen > n) {
                break;
            }

            for (int j = i; j + k <= n; j += k) {
                String test = s.substring(j, j + k);

                if (wDict.containsKey(test)) {
                    int x = curDict.getOrDefault(test, 0);
                    if (x < wDict.get(test)) {
                        curDict.put(test, x + 1);
                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                    } else {
                        // curDict.get(test)==wDict.get(test), slide start to
                        // the next word of the first same word as test
                        String temp;
                        while (!(temp = s.substring(start, start + k)).equals(test)) {
                            decreaseCount(curDict, temp);
                            start += k;
                        }
                        start += k;
                    }
                } else {
                    start = j + k;
                    curDict.clear();
                }

                if (start + wordsLen > n) {
                    break;
                }
            }
        }
        return res;
    }

    public int checkFound(List<Integer> res, int start, int wordsLen, int j, int k,
                          HashMap<String, Integer> curDict, String s) {
        if (start + wordsLen == j + k) {
            res.add(start);
            // slide start to the next word
            decreaseCount(curDict, s.substring(start, start + k));
            return start + k;
        }
        return start;
    }

    public void decreaseCount(HashMap<String, Integer> curDict, String key) {
        // remove key if curDict.get(key)==1, otherwise decrease it by 1
        int x = curDict.get(key);
        if (x == 1)
            curDict.remove(key);
        else
            curDict.put(key, x - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"word", "good", "best", "good"};
        List<Integer> result = solution.findSubstring("wordgoodgoodgoodbestword",
                words);
        System.out.println(result);
    }
}

package set0000.set100.set140.p140;

import java.util.*;

/**
 * Created by senyuanwang on 16/8/21.
 */
public class Solution1 {

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

        Solution1 solution = new Solution1();
        List<String> result = solution.wordBreak(s, dict);
        result.forEach(System.out::println);
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] cs = s.toCharArray();
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

        List<String> list = wordBreak(cs, 0, wordDict, minLen, maxLen, new HashMap<>());

        for (String path : list) {
            result.add(path.substring(0, path.length() - 1));
        }

        return result;
    }

    private List<String> wordBreak(char[] cs, int i, Set<String> wordDict, int minLen, int maxLen, Map<Integer, List<String>> cache) {
        if (i == cs.length) {
            return Arrays.asList("");
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        List<String> result = new ArrayList<>();
        for (int k = minLen; k <= maxLen; k++) {
            if (i + k > cs.length) {
                break;
            }
            String tmp = new String(cs, i, k);
            if (!wordDict.contains(tmp)) {
                continue;
            }
            List<String> sub = wordBreak(cs, i + k, wordDict, minLen, maxLen, cache);
            if (sub.isEmpty()) {
                continue;
            }
            for (String x : sub) {
                result.add(tmp + " " + x);
            }
        }

        cache.put(i, result);
        return result;
    }
}

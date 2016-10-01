package p269;

import java.util.*;

/**
 * Created by wangsenyuan on 9/30/16.
 */
public class Solution {

    public static void main(String[] args) {
        //String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        //String[] words = {"z", "z"};
        //String[] words = {"a", "b", "a"};
        String[] words = {"wrtkj", "wrt"};
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        if (!order(words, graph)) {
            return "";
        }

        int[] d = new int[26];
        Arrays.fill(d, -1);

        for (String word : words) {
            for (char c : word.toCharArray()) {
                d[c - 'a'] = 0;
            }
        }

        for (char v : graph.keySet()) {
            for (char w : graph.get(v)) {
                d[w - 'a']++;
            }
        }

        int wordCnt = 0;
        for (int x : d) {
            if (x >= 0) {
                wordCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (wordCnt > 0) {
            int x = -1;
            for (int i = 0; i < d.length; i++) {
                if (d[i] == 0) {
                    x = i;
                    break;
                }
            }
            if (x < 0) {
                break;
            }
            d[x]--;
            char v = (char) (x + 'a');
            wordCnt--;
            sb.append(v);
            if (!graph.containsKey(v)) {
                continue;
            }
            for (char w : graph.get(v)) {
                d[w - 'a']--;
            }
        }

        if (wordCnt > 0) {
            return "";
        }

        return sb.toString();
    }

    private boolean order(String[] words, Map<Character, List<Character>> graph) {
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String prev = words[i - 1];
            int j = 0;
            while (j < word.length() && j < prev.length() && prev.charAt(j) == word.charAt(j)) {
                j++;
            }
            if (j < prev.length() && j == word.length()) {
                return false;
            }
            if (j == prev.length()) {
                continue;
            }
            char a = prev.charAt(j);
            char b = word.charAt(j);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(b);
        }

        return true;
    }
}

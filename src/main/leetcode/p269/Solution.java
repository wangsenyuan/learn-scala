package p269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by wangsenyuan on 9/30/16.
 */
public class Solution {

    public static void main(String[] args) {
        //String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words = {"z", "z"};
        //        String[] words = {"a", "b", "a"};
        //String[] words = {"wrtkj", "wrt"};
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        if (!order(Arrays.asList(words), graph)) {
            return "";
        }

        Map<Character, Integer> d = new HashMap<>();
        for (Character c : graph.keySet()) {
            if (!d.containsKey(c)) {
                d.put(c, 0);
            }
            for (Character x : graph.get(c)) {
                if (d.containsKey(x)) {
                    d.put(x, d.get(x) + 1);
                } else {
                    d.put(x, 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (d.size() > 0) {
            char selected = '\0';
            for (Character c : d.keySet()) {
                if (d.get(c) == 0) {
                    selected = c;
                    break;
                }
            }
            if (selected == '\0') {
                return "";
            }
            d.remove(selected);
            sb.append(selected);
            for (Character x : graph.get(selected)) {
                d.put(x, d.get(x) - 1);
            }
        }
        return sb.toString();
    }

    private boolean order(List<String> words, Map<Character, List<Character>> graph) {
        List<String> left = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            char h = word.charAt(0);

            if (!graph.containsKey(h)) {
                graph.put(h, new ArrayList<>());
            }

            if (i > 0 && h == words.get(i - 1).charAt(0)) {
                if (word.length() == 1 && left.size() > 0) {
                    return false;
                }
                if (word.length() > 1) {
                    left.add(word.substring(1));
                }
                continue;
            }
            if (left.size() > 0) {
                if (!order(left, graph)) {
                    return false;
                }
            }
            left.clear();
            if (word.length() > 1) {
                left.add(word.substring(1));
            }
            if (i == 0) {
                continue;
            }

            graph.get(words.get(i - 1).charAt(0)).add(h);
        }
        if (left.size() > 0) {
            return order(left, graph);
        }
        return true;
    }
}

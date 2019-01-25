package set200.set260.p267;

import java.util.*;

/**
 * Created by senyuanwang on 15/8/23.
 */
public class Solution {

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }

        int oddChar = 0;
        for (char c : counts.keySet()) {
            int v = counts.get(c);
            if (v % 2 == 0) {
                continue;
            }
            oddChar += 1;
            if (oddChar > 1) {
                return Collections.emptyList();
            }
        }
        Set<String> stringSet = recGenerate(counts, new HashSet<>());
        List<String> result = new ArrayList<>(stringSet.size());
        result.addAll(stringSet);
        return result;
    }

    private Set<String> recGenerate(Map<Character, Integer> countsMap, Set<Character> used) {
        Set<String> result = new HashSet<>();
        if (countsMap.size() == used.size()) {
            result.add("");
        } else {
            for (char key : countsMap.keySet()) {
                if (used.contains(key)) {
                    continue;
                }

                int count = countsMap.get(key);
                used.add(key);
                Set<String> subResult = recGenerate(countsMap, used);
                if (count % 2 == 0) {
                    int half = count / 2;
                    String x = "";
                    for (int i = 0; i < half; i++) {
                        x += key;
                    }
                    for (String sub : subResult) {
                        result.add(x + sub + x);
                    }
                } else {
                    int half = count / 2;
                    String x = "";
                    for (int i = 0; i < half; i++) {
                        x += key;
                    }
                    for (String sub : subResult) {
                        result.add(x + sub.substring(0, sub.length() / 2) + key + sub.substring(sub.length() / 2) + x);
                    }
                }
                used.remove(key);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generatePalindromes("civic"));
    }

}

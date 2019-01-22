package set200.set240.p244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    private Map<String, List<Integer>> indexMap;

    public WordDistance(String[] words) {
        this.indexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!indexMap.containsKey(word)) {
                indexMap.put(word, new ArrayList<>());
            }
            indexMap.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> index1 = indexMap.get(word1);
        List<Integer> index2 = indexMap.get(word2);

        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < index1.size() && j < index2.size(); ) {
            int a = index1.get(i);
            int b = index2.get(j);
            res = Math.min(Math.abs(a - b), res);
            if (a > b) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}

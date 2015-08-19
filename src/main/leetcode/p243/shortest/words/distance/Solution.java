package p243.shortest.words.distance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by senyuanwang on 15/8/18.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int[] indexes1 = new int[words.length];
        int[] indexes2 = new int[words.length];
        int m = 0, n = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                indexes1[m++] = i;
            } else if (word.equals(word2)) {
                indexes2[n++] = i;
            }
        }
        int dist = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < m && j < n; ) {
            int x = indexes1[i];
            int y = indexes2[j];
            dist = Math.min(dist, Math.abs(x - y));
            if (x < y) {
                i++;
            } else {
                j++;
            }
        }

        return dist;
    }
}

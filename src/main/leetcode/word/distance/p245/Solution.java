package word.distance.p245;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
            return shortestWordDistance(words, word1);
        }

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

    private int shortestWordDistance(String[] words, String word1) {
        int[] indexes = new int[words.length];
        int index = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                indexes[index++] = i;
            }
        }

        int res = words.length;

        for(int i = 1; i < index; i++) {
            int a = indexes[i - 1];
            int b = indexes[i];
            res = Math.min(res, b - a);
        }

        return res;
    }
}

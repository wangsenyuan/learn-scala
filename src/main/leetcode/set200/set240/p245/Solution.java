package set200.set240.p245;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return shortestWordDistance(words, word1);
        }

        int a = -1;
        int b = -1;
        int c = words.length;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                a = i;
            } else if (word2.equals(words[i])) {
                b = i;
            }

            if (a >= 0 && b >= 0) {
                int d = a - b;
                if (d < 0) {
                    d = -d;
                }
                if (d < c) {
                    c = d;
                }
            }
        }
        return c;
    }

    private int shortestWordDistance(String[] words, String target) {
        int prev = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (!target.equals(words[i])) {
                continue;
            }
            if (prev >= 0 && i - prev < res) {
                res = i - prev;
            }
            prev = i;
        }
        return res;
    }
}

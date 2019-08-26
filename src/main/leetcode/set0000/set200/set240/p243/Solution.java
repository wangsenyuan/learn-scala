package set0000.set200.set240.p243;

/**
 * Created by senyuanwang on 15/8/18.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int a = -1;
        int b = -1;
        int c = words.length;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                a = i;
            } else if (word2.equals(words[i])) {
                b = i;
            }

            if (a >= 0 && b >= 0 && Math.abs(a - b) < c) {
                c = Math.abs(a - b);
            }
        }
        return c;
    }
}

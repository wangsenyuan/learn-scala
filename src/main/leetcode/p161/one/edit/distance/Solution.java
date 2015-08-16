package p161.one.edit.distance;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == n) {
            return checkSameLength(s.toCharArray(), t.toCharArray());
        } else if (m - n == 1) {
            return checkDiffLength(s.toCharArray(), t.toCharArray());
        } else if (n - m == 1) {
            return checkDiffLength(t.toCharArray(), s.toCharArray());
        } else {
            return false;
        }
    }

    private boolean checkDiffLength(char[] s, char[] t) {
        for(int i = 0; i < s.length; i++) {
            if(i == t.length) {
                return true;
            }

            if(s[i] == t[i]) {
                continue;
            }

            for(int j = i + 1; j < s.length; j++) {
                if(s[j] != t[j - 1]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private boolean checkSameLength(char[] s, char[] t) {
        int dist = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[i]) {
                dist += 1;
            }
            if (dist > 1) {
                return false;
            }
        }

        return dist == 1;
    }


    public static int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }

        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        char[] ss = word1.toCharArray();
        char[] ts = word2.toCharArray();

        int[][] m = new int[ss.length + 1][ts.length + 1];

        for (int i = 0; i < m.length; i++) {
            m[i][0] = i;
        }

        for (int j = 0; j < m[0].length; j++) {
            m[0][j] = j;
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[i].length; j++) {
                int a = m[i - 1][j - 1];
                if (ss[i - 1] != ts[j - 1]) {
                    a += 1;
                }

                int b = m[i - 1][j] + 1;
                int c = m[i][j - 1] + 1;
                m[i][j] = Math.min(a, Math.min(b, c));
            }
        }

        return m[ss.length][ts.length];
    }
}

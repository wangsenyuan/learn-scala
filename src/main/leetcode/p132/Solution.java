package p132;

/**
 * Created by wangsenyuan on 8/18/16.
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n + 1];
        char[] cs = s.toCharArray();
        for (int i = 0; i <= n; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && cs[i - j] == cs[i + j]; j++) {
                if (cut[i - j] + 1 < cut[i + j + 1]) {
                    cut[i + j + 1] = cut[i - j] + 1;
                }
            } // odd length palindrome


            for (int j = 1; i - j + 1 >= 0 && i + j < n && cs[i - j + 1] == cs[i + j]; j++) {
                if (cut[i - j + 1] + 1 < cut[i + j + 1]) {
                    cut[i + j + 1] = cut[i - j + 1] + 1;
                }
            }// even length palindrome
        }
        return cut[n];
    }

    public static int minCut1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] fx = new int[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (len == 0) {
                    fx[i][j] = 0;
                    continue;
                }

                if (len == 1) {
                    fx[i][j] = cs[i] == cs[j] ? 0 : 1;
                    continue;
                }

                if (fx[i + 1][j - 1] == 0 && cs[i] == cs[j]) {
                    fx[i][j] = 0;
                    continue;
                }

                fx[i][j] = j - i;

                for (int k = i; k < j; k++) {
                    if (fx[i][k] + fx[k + 1][j] + 1 < fx[i][j]) {
                        fx[i][j] = fx[i][k] + fx[k + 1][j] + 1;
                    }
                }
            }
        }

        return fx[0][n - 1];
    }
}

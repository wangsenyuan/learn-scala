package longest.palindromic.substring.p005;

/**
 * Created by senyuanwang on 15/12/3.
 */
public class Solution {

    public String longestPalindrome1(String s) {
        char[] cs = s.toCharArray();

        int n = cs.length;
        boolean[][] table = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            table[i][i] = true; //itself is palindrome
        }

        int maxLen = 1;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (cs[i] == cs[i + 1]) {
                maxLen = 2;
                table[i][i + 1] = true;
                index = i;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && cs[i] == cs[j]) {
                    table[i][j] = true;
                    if (k > maxLen) {
                        maxLen = k;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index, index + maxLen);
    }

    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();

        int n = cs.length;
        int index = 0, maxLen = 1;
        for(int i = 1; i < n; i++) {
            int low = i - 1, high = i;

            while(low >= 0 && high < n && cs[low] == cs[high]) {
                if(high - low + 1 > maxLen) {
                    index = low;
                    maxLen = high - low + 1;
                }

                low -= 1;
                high += 1;
            }

            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < n && cs[low] == cs[high]) {
                if(high - low + 1 > maxLen) {
                    index = low;
                    maxLen = high - low + 1;
                }

                low -= 1;
                high += 1;
            }
        }

        return s.substring(index, index + maxLen);
    }
}

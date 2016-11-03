package p316;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/11/2.
 */
public class Solution1 {

    public static void main(String[] args) {
        //System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] positions = new int[26];
        Arrays.fill(positions, -1);
        char[] res = new char[s.length()];

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (positions[c - 'a'] >= 0) {
                int a = positions[c - 'a'];
                int b = a + 1;
                while (b < j && res[b] == '\0') {
                    b++;
                }
                if (b == j || c < res[b]) {
                    continue;
                }

                res[a] = '\0';
            }

            res[j] = c;
            positions[c - 'a'] = j;
            j++;
        }

        String ans = "";
        for (int i = 0; i < j; i++) {
            if (res[i] != '\0') {
                ans += res[i];
            }
        }
        return ans;
    }
}

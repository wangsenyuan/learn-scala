package set0000.set100.set180.p186;

/**
 * Created by wangsenyuan on 9/2/16.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = "the sky is blue".toCharArray();
        solution.reverseWords(s);
        System.out.println(new String(s));
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s, i, s.length - 1);
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}

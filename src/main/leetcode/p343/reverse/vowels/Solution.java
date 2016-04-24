package p343.reverse.vowels;

/**
 * Created by senyuanwang on 16/4/23.
 */
public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] cs = s.toCharArray();

        for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
            while (i < j && !isVowel(cs[i])) {
                i++;
            }

            while (i < j && !isVowel(cs[j])) {
                j--;
            }
            char c = cs[i];
            cs[i] = cs[j];
            cs[j] = c;
        }

        return new String(cs);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }
}

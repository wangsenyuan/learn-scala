package set0000.set200.set210.p214;

/**
 * Created by senyuanwang on 15/5/23.
 */
public class Solution1 {

    public static boolean isPalindrom(char[] str, int s, int e) {
        int i = s;
        int j = e - 1;
        while (i < j) {
            if (str[i] != str[j]) {
                return false;
            }
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int j = chars.length;

        while (j > 0) {
            if (isPalindrom(chars, 0, j)) {
                break;
            }
            j -= 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = j; i < chars.length; i++) {
            sb.insert(0, chars[i]);
        }

        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }
}

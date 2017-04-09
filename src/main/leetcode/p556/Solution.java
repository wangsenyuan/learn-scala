package p556;

/**
 * Created by wangsenyuan on 09/04/2017.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));
        System.out.println(nextGreaterElement(132));
        System.out.println(nextGreaterElement(123));
        System.out.println(nextGreaterElement(101));

        System.out.println(nextGreaterElement(110));
        System.out.println(nextGreaterElement(1999999999));
    }

    public static int nextGreaterElement(int n) {
        String str = String.valueOf(n);

        char[] s = str.toCharArray();

        int i = s.length - 2;
        while (i >= 0 && s[i] >= s[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = s.length - 1;
        while (s[j] <= s[i]) {
            j--;
        }

        reverse(s, i, j);
        i++;
        j = s.length - 1;
        while (i < j) {
            reverse(s, i, j);
            i++;
            j--;
        }

        long res = Long.parseLong(new String(s));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }

    private static void reverse(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

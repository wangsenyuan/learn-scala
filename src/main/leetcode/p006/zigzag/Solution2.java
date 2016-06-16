package p006.zigzag;

/**
 * Created by wangsenyuan on 6/16/16.
 */
public class Solution2 {

    public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows == 1) {
            return s;
        }

        //        char[] as = s.toCharArray();
        int n = s.length();

        char[] cs = new char[n];

        int[] p = {2 * (nRows - 1), 0};
        int x = 0;
        int j = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            cs[i] = s.charAt(j);
            if (j + p[x] >= n) {
                j = ++r;
                p[0] -= 2;
                p[1] += 2;
                x = 0;
                if (p[x] == 0) {
                    x = 1;
                }
                continue;
            }

            j += p[x];
            if (p[1 - x] > 0) {
                x = 1 - x;
            }
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
        System.out.println(convert("PAYPALISHIRING", 3));

        System.out.println(convert("ABCDEF", 4));
    }
}

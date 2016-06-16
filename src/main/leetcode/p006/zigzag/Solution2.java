package p006.zigzag;

/**
 * Created by wangsenyuan on 6/16/16.
 */
public class Solution2 {

    public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int n = s.length();

        int[] p = {2 * (nRows - 1), 0};
        int x = 0;
        int j = 0;
        int r = 0;
        //PAHNAPLSIIGYIR
        //PAHNAPLSIIGYIR
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(j));
            if (j + p[x] >= n) {
                j = ++r;
                p[0] -= 2;
                p[1] += 2;
                x = 0;
                if (p[x] == 0) {
                    x = (x + 1) % 2;
                }
                continue;
            }

            j += p[x];
            x = (x + 1) % 2;
            if (p[x] == 0) {
                x = (x + 1) % 2;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //        System.out.println(convert("AB", 1));
        //        System.out.println(convert("PAYPALISHIRING", 3));

        System.out.println(convert("ABCDEF", 4));
    }
}

package p091;

/**
 * Created by senyuanwang on 16/8/6.
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] cs = s.toCharArray();

        int a = 1;
        int b = 1;

        for (int i = 0; i < cs.length; i++) {
            int c = a;
            if (cs[i] == '0') {
                a = 0;
            }

            if (i >= 1 && ((cs[i - 1] == '1') || (cs[i - 1] == '2' && cs[i] <= '6'))) {
                a += b;
            }
            b = c;
        }
        return a;
    }
}

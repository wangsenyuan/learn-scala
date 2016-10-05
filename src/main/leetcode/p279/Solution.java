package p279;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/10/5.
 */
public class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        int a = -1;
        int b = (int) Math.sqrt(n);
        n -= b * b;
        b += b + 1;
        while (a <= b) {
            if (n < 0)
                n += b -= 2;
            else if (n > 0)
                n -= a += 2;
            else
                return a < 0 ? 1 : 2;
        }
        return 3;
    }

    private int[] f = new int[]{};
    int p = 1;

    public int numSquares1(int n) {
        if (f.length > n) {
            return f[n];
        }
        f = Arrays.copyOf(f, n + 1);

        while (p <= n) {
            int x = Integer.MAX_VALUE;
            for (int i = 1; i * i <= p; i++) {
                if (f[p - i * i] + 1 < x) {
                    x = f[p - i * i] + 1;
                }
            }
            f[p++] = x;
        }


        return f[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*for (int i = 1; i <= 100; i++) {
            System.out.println(solution.numSquares1(i));
        }*/
        System.out.println(solution.numSquares1(12));
    }
}

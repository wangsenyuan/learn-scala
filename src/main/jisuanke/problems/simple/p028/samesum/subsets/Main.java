package problems.simple.p028.samesum.subsets;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
        /*for (int i = 1; i <= 39; i++) {
            System.out.println(solve(i));
        }*/
    }

    public static long solve(int n) {
        long sum = n * (n + 1) / 2;
        if (sum % 2 == 1) {
            //no way to split the numbers
            return 0;
        }

        int m = (int) (sum / 2);

        long[][] df = new long[n + 1][m + 1];
        //df[i][j] means the ways to use the previous i numbers to construct sets with size of j
//        Arrays.fill(df, n + 1, m + 1, -1);
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(df[i], 0, m + 1, -1);
        }
        long res = 0;
        for (int i = 1; i < n + 1; i++) {
            res += f(n, i, m, df);
        }
        return res / 2;
    }

    public static long f(int n, int i, int j, long[][] df) {
        if (j < 0) {
            return 0;
        }
        if (i == n + 1) {
            return j == 0 ? 1 : 0;
        }

        if (df[i][j] >= 0) {
            return df[i][j];
        }
        long res = 0;
        for (int k = i + 1; k <= n + 1; k++) {
            res += f(n, k, j - i, df);
        }
        df[i][j] = res;
        return res;
    }

}

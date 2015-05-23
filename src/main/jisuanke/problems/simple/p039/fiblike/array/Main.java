package problems.simple.p039.fiblike.array;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int x = fibLike(a, b, n - 1);
            System.out.println(String.format("Case #%d: %d", i, x));
        }
    }

    private static int fibLike(int a, int b, int n) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }

        int c = a + b;
        if (c < 10) {
            return fibLike(b, c, n - 1);
        } else {
            return fibLike(c / 10, c % 10, n - 1);
        }
    }
}

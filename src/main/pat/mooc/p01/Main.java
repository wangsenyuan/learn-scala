package mooc.p01;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/8/18.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String symbol = scanner.next();
        StringBuilder result = new StringBuilder();
        int m = calculate(n);
        int ax = 2 * m - 1;
        int ay = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < ay; j++) {
                result.append(' ');
            }
            for (int j = 0; j < ax; j++) {
                result.append(symbol);
            }
            for (int j = 0; j < ay; j++) {
                result.append(' ');
            }
            result.append('\n');
            ax -= 2;
            ay += 1;
        }

        ax += 4;
        ay -= 2;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < ay; j++) {
                result.append(' ');
            }
            for (int j = 0; j < ax; j++) {
                result.append(symbol);
            }
            for (int j = 0; j < ay; j++) {
                result.append(' ');
            }
            result.append('\n');
            ax += 2;
            ay -= 1;
        }
        result.append(n - 2 * m * m + 1);
        System.out.println(result.toString());
    }

    private static int calculate(int n) {
        //2 * x * x - 1 == n
        //return x;
        return (int) Math.sqrt((n + 1) / 2);
    }
}

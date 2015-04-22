package poj.p3684;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/19.
 */
public class Main {

    private static double g = 10.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < c; i++) {
            test(scanner);
        }
    }

    private static void test(Scanner scanner) {
        String[] line = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        int t = Integer.parseInt(line[3]);

        double[] ys = new double[n];
        for (int i = 0; i < n; i++) {
            ys[i] = calc(t - i, h);
        }

        Arrays.sort(ys);

        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%.2f%c", ys[i] + 2 * r * i / 100.0, i + 1 == n ? '\n' : ' '));
        }
    }

    public static double calc(int t, int h) {
        if (t < 0) {
            return h;
        }

        double t0 = Math.sqrt(2 * h / g);

        int k = (int) (t / t0);

        if (k % 2 == 0) {
            double d = t - k * t0;
            return h - g * d * d / 2;
        } else {
            double d = k * t0 + t0 - t;
            return h - g * d * d / 2;
        }
    }
}

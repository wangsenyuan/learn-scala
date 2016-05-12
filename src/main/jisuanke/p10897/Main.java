package p10897;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 5/12/16.
 *  K = \sqrt {(s-a)(s-b)(s-c)(s-d) - abcd  \cdot \cos^2 \left(\frac{\alpha + \gamma}{2}\right)}
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ca = scanner.nextInt();

        for (int i = 1; i <= ca; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            double area = maxFourSidesPolygonArea(a, b, c, d);
            if (area < 0) {
                System.out.printf("Case %d: -1\n", i);
            } else {
                System.out.printf("Case %d: %.6f\n", i, area);
            }
        }
    }


    public static double maxFourSidesPolygonArea(double a, double b, double c, double d) {
        double s = (a + b + c + d) / 2;

        if (s <= a || s <= b || s <= c || s <= d) {
            return -1d;
        }

        double x = (s - a) * (s - b) * (s - c) * (s - d);
//        double y = a * b * c * d / 2;

        return Math.sqrt(x);
    }
}

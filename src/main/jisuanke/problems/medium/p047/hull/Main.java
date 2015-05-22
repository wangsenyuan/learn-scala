package problems.medium.p047.hull;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Created by senyuanwang on 15/5/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            ps[i] = new P(x, y);
        }

        Arrays.sort(ps);

        P[] hull = convexHull(ps);
        double res = 0.0;
        for (int i = 1; i < hull.length; i++) {
            res += sqrt(hull[i].dist(hull[i - 1]));
        }
        res += sqrt(hull[0].dist(hull[hull.length - 1]));
        System.out.println(String.format("%.2f", res));
    }

    static P[] convexHull(P[] ps) {
        int n = ps.length;
        P[] qs = new P[n * 2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (k > 1 && (qs[k - 1].sub(qs[k - 2]).det(ps[i].sub(qs[k - 1]))) <= 0) {
                k--;
            }
            qs[k++] = ps[i];
        }
        for (int i = n - 2, t = k; i >= 0; i--) {
            while (k > t && (qs[k - 1].sub(qs[k - 2]).det(ps[i].sub(qs[k - 1]))) <= 0) {
                k--;
            }
            qs[k++] = ps[i];
        }
        qs = Arrays.copyOf(qs, k - 1);
        return qs;
    }
}


class P implements Comparable<P> {
    final static double EPS = 1e-6;

    final double x, y;

    public P(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public P add(P that) {
        return new P(add(this.x, that.x), add(this.y, that.y));
    }

    public P sub(P that) {
        return new P(add(this.x, -that.x), add(this.y, -that.y));
    }

    public P mul(double d) {
        return new P(this.x * d, this.y * d);
    }

    //inner product
    public double dot(P that) {
        return add(x * that.x, y * that.y);
    }

    //outter product
    public double det(P that) {
        return add(x * that.y, -y * that.x);
    }

    static double add(double a, double b) {
        if (abs(a + b) < EPS * (abs(a) + abs(b))) {
            return 0d;
        } else {
            return a + b;
        }
    }

    public double dist(P that) {
        return (this.sub(that)).dot(this.sub(that));
    }

    @Override
    public int compareTo(P that) {
        if (abs(this.x - that.x) <= EPS) {
            if (abs(this.y - that.y) <= EPS) {
                return 0;
            } else {
                return this.y > that.y ? 1 : -1;
            }
        } else {
            return this.x > that.x ? 1 : -1;
        }
    }
}
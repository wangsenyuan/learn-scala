package problems.simple.p030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/17.
 */
public class Main {
    static class P implements Comparable<P> {
        final int a, b;

        public P(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(P that) {
            return this.a * that.b - this.b * that.a;
        }

        @Override
        public String toString() {
            return a + "/" + b;
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("0/1");
        List<P> ps = new ArrayList<P>(n);
        for(int i = 1; i < n; i++) {
            for(int j = n; j > i; j--) {
                int d = gcd(i, j);
                if(d == 1) {
                    ps.add(new P(i, j));
                }
            }
        }
        Collections.sort(ps);
        for(P p : ps) {
            System.out.println(p);
        }
        System.out.println("1/1");
    }
}

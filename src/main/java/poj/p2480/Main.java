package poj.p2480;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long res = solve(n);
            System.out.println(res);
        }
    }

    private static int MAX_N = 1000010;
    private static List<Integer> primes = new ArrayList<Integer>();

    private static void init() {
        BitSet set = new BitSet();

        for (int x = 2; x < MAX_N; ) {
            primes.add(x);
            for (int y = 2 * x; y < MAX_N; y += x) {
                set.set(y);
            }
            x = set.nextClearBit(x + 1);
        }
    }

    static class Pair {
        final int first;
        final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static List<Pair> getFactors(int num) {
        List<Pair> res = new ArrayList<Pair>();
        for (int i = 0; i < primes.size(); i++) {
            int x = primes.get(i);
            if (x > num / x) {
                break;
            }
            if (num % x == 0) {
                int cnt = 0;
                while (num % x == 0) {
                    cnt++;
                    num /= x;
                }
                res.add(new Pair(x, cnt));
            }
        }

        if (num > 1) {
            res.add(new Pair(num, 1));
        }
        return res;
    }

    private static long solve(int n) {
        long ans = 1;
        List<Pair> factors = getFactors(n);
        for (int i = 0; i < factors.size(); i++) {
            Pair cur = factors.get(i);
            // p = cur.first
            // p * phi(n / p )
            // n / p
            long res = pow(cur.first, cur.second);
            res = res + cur.second * res - cur.second * res / cur.first;
            ans *= res;
        }

        return ans;
    }

    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }
}

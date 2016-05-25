package codejam.year2015.round3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 5/25/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long s = scanner.nextLong();
            long as = scanner.nextLong();
            long cs = scanner.nextLong();
            long rs = scanner.nextLong();

            long m = scanner.nextInt();
            long am = scanner.nextLong();
            long cm = scanner.nextLong();
            long rm = scanner.nextLong();

            long[] ss = new long[n];
            ss[0] = s;
            long[] ms = new long[n];
            ms[0] = m;
            int[] p = new int[n];
            for (int j = 1; j < n; j++) {
                ss[j] = (ss[j - 1] * as + cs) % rs;
                ms[j] = (int) ((ms[j - 1] * am + cm) % rm);
                p[j] = (int) (ms[j] % j);
            }

            long result = play(n, ss, p, d);
            System.out.printf("Case #%d: %d\n", i, result);
        }

    }

    public static long play(int n, long[] s, int[] m, long d) {
        long[] low = new long[n];
        long[] high = new long[n];

        low[0] = Math.max(0, s[0] - d);
        high[0] = s[0];

        for (int i = 1; i < n; i++) {
            int p = m[i];
            updateInterval(low, high, p, i, Math.max(s[i] - d, 0), s[i]);
        }

        X[] xs = new X[2 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (low[i] < 0) {
                continue;
            }

            xs[k++] = new X(low[i], 1);
            xs[k++] = new X(high[i], -1);
        }
        xs = Arrays.copyOf(xs, k);
        Arrays.sort(xs);

        long max = 0;
        long sum = 0;

        for (X x : xs) {
            sum = Math.max(sum, 0) + x.value;
            max = Math.max(sum, max);
        }

        return max;
    }

    private static void updateInterval(long[] low, long[] high, int p, int i, long l, long h) {
        long pl = low[p];
        long ph = high[p];

        if (pl > h || l > ph) {
            low[i] = -1;
            high[i] = -1;
            return;
        }

        low[i] = Math.max(pl, l);
        high[i] = Math.min(ph, h);
    }

    static class X implements Comparable<X> {
        final long at;
        final int value;

        public X(long at, int value) {
            this.at = at;
            this.value = value;
        }

        @Override
        public int compareTo(X that) {
            if (this.at < that.at) {
                return -1;
            }

            if (this.at > that.at) {
                return 1;
            }

            return that.value - this.value;
        }
    }
}

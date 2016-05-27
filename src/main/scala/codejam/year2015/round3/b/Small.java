package codejam.year2015.round3.b;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 5/26/16.
 */
public class Small {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long[] sums = new long[n - k + 1];
            for (int j = 0; j < n - k + 1; j++) {
                sums[j] = scanner.nextLong();
            }
            long maxDiff = findMaxDiff(sums, n, k);
            System.out.printf("Case #%d: %d\n", i, maxDiff);
        }
    }

    private static long findMaxDiff(long[] sums, int n, int k) {
        long[] nums = new long[n];

        nums[k - 1] = sums[0];

        for (int i = k; i < n; i++) {
            nums[i] = sums[i - k + 1] - sums[i - k] + nums[i - k];
        }

        long[] lo = new long[k];
        Arrays.fill(lo, Long.MAX_VALUE);
        long[] hi = new long[k];
        Arrays.fill(hi, Long.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int j = i % k;
            lo[j] = Math.min(lo[j], nums[i]);
            hi[j] = Math.max(hi[j], nums[i]);
        }

        long q = 0;
        for (int i = 0; i < k; i++) {
            q += lo[i];
            hi[i] -= lo[i];
            lo[i] = 0;
        }

        while (q < 0) {
            q += k;
        }

        q = q % k;

        long l = 0;
        long a = 0;
        for (int i = 0; i < k; i++) {
            l = Math.max(l, Math.abs(hi[i] - lo[i]));
            a += Math.abs(hi[i] - lo[i]);
        }

        if (l * k - a >= q) {
            return l;
        } else {
            return l + 1;
        }
    }

}

package poj.p2104;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/25.
 */
public class Main {
    private final long[] nums;
    private final long[] xs;
    private final long[][] buckets;
    private final int n;
    private int b;

    public Main(long[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.xs = new long[n];
        this.b = (int) Math.sqrt(n);

        if (b * b < n) {
            b = b + 1;
        }

        this.buckets = new long[n / b + 1][];

        int k = 0;
        for (int i = 0; i < n; i++) {
            int j = i / b;

            if (i % b == 0) {
                buckets[j] = new long[b];
                k = 0;
            }
            buckets[j][k++] = nums[i];
            xs[i] = nums[i];
        }

        Arrays.sort(xs);

        for (long[] bucket : buckets) {
            if (bucket != null) {
                Arrays.sort(bucket);
            }
        }
    }

    public long query(int l, int r, int k) {
        int lb = -1, ub = n - 1;

        while (ub - lb > 1) {
            int md = (lb + ub) / 2;
            long x = xs[md];
            int tl = l, tr = r + 1, c = 0;

            while (tl < tr && tl % b != 0) {
                if (nums[tl++] <= x) {
                    c += 1;
                }
            }

            while (tl < tr && tr % b != 0) {
                if (nums[--tr] <= x) {
                    c += 1;
                }
            }

            while (tl < tr) {
                int xb = tl / b;
                int count = upperBound(buckets[xb], x);
                c += Math.max(count, 0);
                tl += b;
            }

            if (c >= k) {
                ub = md;
            } else {
                lb = md;
            }
        }

        return xs[ub];
    }

    public static int upperBound(long[] array, long key) {
        int i = 0, j = array.length - 1;
        int idx = -2;
        while (i <= j) {
            int mid = (i + j) / 2;

            if (array[mid] > key) {
                j = mid - 1;
            } else {
                i = mid + 1;
                idx = mid;
            }
        }
        return idx + 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        String[] secondLine = scanner.nextLine().split("\\s+");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(secondLine[i]);
        }

        Main solution = new Main(nums);

        for (int i = 0; i < q; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            int l = Integer.parseInt(line[0]) - 1;
            int r = Integer.parseInt(line[1]) - 1;
            int k = Integer.parseInt(line[2]);
            long x = solution.query(l, r, k);
            System.out.println(x);
        }
    }
}

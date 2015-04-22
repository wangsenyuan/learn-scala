package poj.p2785;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] as = new long[n], bs = new long[n], cs = new long[n], ds = new long[n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            as[i] = Long.parseLong(line[0]);
            bs[i] = Long.parseLong(line[1]);
            cs[i] = Long.parseLong(line[2]);
            ds[i] = Long.parseLong(line[3]);
        }

        long res = solve(as, bs, cs, ds, n);

        System.out.println(res);
    }

    public static long solve(long[] as, long[] bs, long[] cs, long[] ds, int n) {
        long[] cds = new long[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cds[i * n + j] = cs[i] + ds[j];
            }
        }

        Arrays.sort(cds);

        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long cd = -(as[i] + bs[j]);
                res += upperBound(cds, cd) - lowerBound(cds, cd);

            }
        }
        return res;
    }

    public static int upperBound(long[] array, long key) {
        int i = 0, j = array.length - 1;

        int idx = -2;
        while (i <= j) {
            int mid = (i + j) / 2;

            if (array[mid] > key) {
                j = mid - 1;
            } else if (array[mid] < key) {
                i = mid + 1;
            } else {
                i = mid + 1;
                idx = mid;
            }
        }
        return idx + 1;
    }

    public static int lowerBound(long[] array, long key) {
        int i = 0, j = array.length - 1;

        int idx = -1;
        while (i <= j) {
            int mid = (i + j) / 2;

            if (array[mid] > key) {
                j = mid - 1;
            } else if (array[mid] < key) {
                i = mid + 1;
            } else {
                j = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }

}

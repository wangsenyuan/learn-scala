package poj.p3468;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);
        String[] secondLine = scanner.nextLine().split("\\s+");
     /*   long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(secondLine[i]);
        }*/
        Solution1 solution = new Solution1(secondLine);
        for (int i = 0; i < q; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            if (line[0].equals("C")) {
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                int x = Integer.parseInt(line[3]);
                solution.add(a, b, x);
            } else if (line[0].equals("Q")) {
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                long sum = solution.sum(a, b);
                System.out.println(sum);
            }
        }
    }

    private static class Solution {
        private final int n;
        private final long[] data, datb;

        public Solution(long[] nums) {
            this.n = nums.length;
            this.data = new long[(1 << 18) - 1];
            this.datb = new long[(1 << 18) - 1];
            for (int i = 0; i < n; i++) {
                add(i, i + 1, nums[i]);
            }
        }

        private void add(int a, int b, long x, int k, int l, int r) {
            if (a <= l && r <= b) {
                data[k] += x;
            } else if (l < b && a < r) {
                datb[k] += (Math.min(b, r) - Math.max(a, l)) * x;
                add(a, b, x, k * 2 + 1, l, (l + r) / 2);
                add(a, b, x, k * 2 + 2, (l + r) / 2, r);
            }
        }

        public void add(int a, int b, long x) {
            add(a, b, x, 0, 0, n);
        }

        private long sum(int a, int b, int k, int l, int r) {
            if (b <= l || r <= a) {
                return 0;
            } else if (a <= l && r <= b) {
                return data[k] * (r - l) + datb[k];
            } else {
                long res = (Math.min(b, r) - Math.max(a, l)) * data[k];
                res += sum(a, b, 2 * k + 1, l, (l + r) / 2);
                res += sum(a, b, 2 * k + 2, (l + r) / 2, r);
                return res;
            }
        }

        public long sum(int a, int b) {
            return sum(a, b, 0, 0, n);
        }
    }

    private static class Solution1 {
        private final int n;
        private final long[] bit0, bit1;

        public Solution1(String[] nums) {
            this.n = nums.length;
            this.bit0 = new long[n + 1];
            this.bit1 = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                add(bit0, i, Long.parseLong(nums[i - 1]));
            }
        }

        private void add(long[] bit, int i, long x) {
            while (i <= n) {
                bit[i] += x;
                i += i & -i;
            }
        }

        public void add(int l, int r, long x) {
            add(bit0, l, -x * (l - 1));
            add(bit1, l, x);
            add(bit0, r + 1, x * r);
            add(bit1, r + 1, -x);
        }

        private long sum(long[] bit, int i) {
            long res = 0;
            while (i > 0) {
                res += bit[i];
                i -= i & -i;
            }
            return res;
        }

        public long sum(int l, int r) {
            long res = 0;
            res += sum(bit0, r) + sum(bit1, r) * r;
            res -= sum(bit0, l - 1) + sum(bit1, l - 1) * (l - 1);
            return res;
        }
    }
}

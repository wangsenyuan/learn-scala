package codechef.easy.marblegf;

import java.util.Scanner;

/**
 * Created by senyuanwang on 2017/1/31.
 */
public class Solution {
    private long[] tree;
    private int n;

    private void update(int idx, int diff) {
        idx++;
        while (idx <= n) {
            tree[idx] += diff;
            idx += idx & -idx;
        }
    }

    public long sum(int idx) {
        long res = 0;
        idx++;
        while (idx > 0) {
            res += tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }

    public void solve() {
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            this.tree = new long[n + 1];
            int q = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                update(i, scanner.nextInt());
            }

            for (int i = 0; i < q; i++) {
                String tp = scanner.next();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (tp.equals("S")) {
                    System.out.println(sum(b) - sum(a - 1));
                } else if (tp.equals("G")) {
                    update(a, b);
                } else {
                    update(a, -b);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}

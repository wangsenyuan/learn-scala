package codechef.easy.permsuff;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 27/02/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt() - 1;
            }

            Pair[] pairs = new Pair[m];
            for (int i = 0; i < m; i++) {
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt() - 1;
                pairs[i] = new Pair(l, r);
            }
            Arrays.sort(pairs);

            int left = pairs[0].l;
            int right = pairs[0].r;

            for (int i = 1; i < m; i++) {
                Pair cur = pairs[i];
                if (cur.l > right) {
                    Arrays.sort(p, left, right + 1);
                    left = cur.l;
                    right = cur.r;
                } else {
                    if (cur.r > right) {
                        right = cur.r;
                    }
                }
            }
            Arrays.sort(p, left, right + 1);

            boolean ans = true;
            for (int i = 0; i < n && ans; i++) {
                ans = p[i] == i;
            }
            if (ans) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        final int l, r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.l < that.l || (this.l == that.l && this.r < that.r)) {
                return -1;
            } else if (this.l == that.l && this.r == that.r) {
                return 0;
            } else {
                return 1;
            }
        }
    }

}

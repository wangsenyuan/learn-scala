package poj.p3276;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            return;
        }

        String[] dirs = new String[n];
        for (int i = 0; i < n; i++) {
            dirs[i] = scanner.nextLine();
        }
        Solution solution = new Solution(dirs);
        System.out.println(solution.getK() + " " + solution.getM());
    }

    private static class Solution {
        private final String[] dirs;
        private final int n;
        private final int[] xs;
        private final int[] fs;
        private int k;
        private int m;

        private Solution(String[] dirs) {
            this.dirs = dirs;
            this.n = dirs.length;
            this.xs = new int[n];
            for (int i = 0; i < n; i++) {
                String dir = dirs[i];
                if ("F".equals(dir)) {
                    xs[i] = 0;
                } else {
                    xs[i] = 1;
                }
            }
            this.fs = new int[n];

            solve();
        }

        private int solve(int k) {
//            int[] fs = new int[n];
            Arrays.fill(fs, 0);
            int sum = 0;
            int res = 0;
            for (int i = 0; i + k <= n; i++) {
                if (xs[i] + sum % 2 == 1) {
                    fs[i] = 1;
                }
                res += fs[i];
                sum += fs[i];
                if (i - k + 1 >= 0) {
                    sum -= fs[i - k + 1];
                }
            }

            for (int i = n - k + 1; i < n; i++) {
                if (xs[i] + sum % 2 == 1) {
                    return -1;
                }
                if (i - k + 1 >= 0) {
                    sum -= fs[i - k + 1];
                }
            }
            return res;
        }

        private void solve() {
            this.k = 1;
            this.m = n;
            for (int i = 1; i <= n; i++) {
                int res = solve(i);
                if (res >= 0 && m > res) {
                    this.k = i;
                    this.m = res;
                }
            }
        }

        public int getK() {
            return k;
        }

        public int getM() {
            return m;
        }
    }
}

package problems.simple.p318;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/2.
 */
public class Main {

    static class Grid {
        final int n;
        final boolean[][] grid;

        public Grid(int n) {
            this.n = n;
            this.grid = new boolean[n][n];
        }

        public void set(int i, int j) {
            grid[i][j] = true;
        }

        public boolean check(int x, int y) {
            //同一列
            for (int i = 0; i < x; i++) {
                if (grid[i][y]) {
                    return false;
                }
            }

            for (int j = 0; j < n; j++) {
                if (grid[x][j]) {
                    return false;
                }
            }

            for (int i = -n + 1; i < n; i++) {
                if (i == 0) {
                    continue;
                }
                int a = x - i;
                int b = y - i;
                if (a >= 0 && a <= x - 1 && b >= 0 && b <= n - 1 && grid[a][b]) {
                    return false;
                }
            }

            for (int i = -n + 1; i < n; i++) {
                if (i == 0) {
                    continue;
                }
                int a = x - i;
                int b = y + i;
                if (a >= 0 && a <= x - 1 && b >= 0 && b <= n - 1 && grid[a][b]) {
                    return false;
                }
            }

            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            String sep = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]) {
                        sb.append(sep);
                        sb.append(j + 1);
                        sep = " ";
                        break;
                    }
                }
            }
//            sb.append("\n");
            return sb.toString();
        }

        public void unset(int i, int j) {
            grid[i][j] = false;
        }
    }

    private final int n;
    private List<String> result;

    //    private final int[][] grid;
    public Main(int n) {
        this.n = n;
//        this.grid = new int[n][n];
        this.result = new ArrayList<String>();
    }

    private void solve(Grid grid, int i) {
        if (i == n) {
            result.add(grid.toString());
            return;
        }

        for (int j = 0; j < n; j++) {
            if (grid.check(i, j)) {
                grid.set(i, j);
                solve(grid, i + 1);
                grid.unset(i, j);
            }
        }
    }

    public List<String> solve(int[] cnt) {
        Grid grid = new Grid(n);
        solve(grid, 0);
        Collections.sort(result);
        cnt[0] = result.size();
        return result.subList(0, 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main solution = new Main(n);
        int[] count = new int[1];
        List<String> result = solution.solve(count);
        for (String a : result) {
            System.out.println(a);
        }
        System.out.println(count[0]);
    }
}

package poj.p3279;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/19.
 */
public class Main {

    private static int[] xDirs = new int[]{-1, 0, 0, 0, 1};
    private static int[] yDirs = new int[]{0, -1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] flip = new int[m][n];

//        memset(flip, m, n);

        int[][] opt = new int[m][n];

        boolean solved = solve(grid, flip, opt, m, n);
        if (solved) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(opt[i][j]);
                    if (j == n - 1) {
                        System.out.println();
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static boolean solve(int[][] grid, int[][] flip, int[][] opt, int m, int n) {
        int res = -1;

        for (int i = 0; i < 1 << n; i++) {
            memset(flip, m, n);
            for (int j = 0; j < n; j++) {
                flip[0][n - j - 1] = i >> j & 1;
            }
            int num = solve(grid, flip, m, n);

            if (num >= 0 && (res < 0 || num < res)) {
                res = num;
                memcpy(flip, opt, m, n);
            }
        }

        return res >= 0;
    }

    private static void memcpy(int[][] flip, int[][] opt, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                opt[i][j] = flip[i][j];
            }
        }
    }

    private static void memset(int[][] flip, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flip[i][j] = 0;
            }
        }
    }

    public static int solve(int[][] grid, int[][] flip, int m, int n) {
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (get(grid, flip, i - 1, j, m, n) > 0) {
                    flip[i][j] = 1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (get(grid, flip, m - 1, j, m, n) > 0) {
                return -1;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += flip[i][j];
            }
        }
        return res;
    }

    public static int get(int[][] grid, int[][] flip, int i, int j, int m, int n) {
        int c = grid[i][j];
        for (int k = 0; k < xDirs.length; k++) {
            int x = xDirs[k] + i;
            int y = yDirs[k] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                c += flip[x][y];
            }
        }
        return c % 2;
    }
}

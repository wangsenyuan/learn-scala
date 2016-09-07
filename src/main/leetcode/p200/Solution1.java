package p200;

/**
 * Created by wangsenyuan on 9/7/16.
 */
public class Solution1 {


    private static int[][] dirs = new int[][] {new int[] {-1, 0}, new int[] {0, -1},};

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < dirs.length; k++) {
                    int a = dirs[k][0] + i;
                    int b = dirs[k][1] + j;
                    if (a < 0 || a >= m || b < 0 || b >= n) {
                        continue;
                    }
                    if (grid[a][b] == '0') {
                        continue;
                    }
                    uf.union(i * n + j, a * n + b);
                }
            }
        }

        int sz = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int x = i * n + j;
                int p = uf.find(x);
                if (x == p) {
                    sz++;
                }
            }
        }

        return sz;
    }
}


class UF {
    private final int[] array;

    public UF(int sz) {
        this.array = new int[sz];
        for (int i = 0; i < sz; i++) {
            array[i] = i;
        }
    }

    public int find(int x) {
        int p = this.array[x];
        if (p == x) {
            return x;
        }
        this.array[x] = find(p);
        return this.array[x];
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        this.array[a] = b;
    }

}

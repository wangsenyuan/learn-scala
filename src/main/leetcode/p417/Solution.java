package p417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by wangsenyuan on 09/10/2016.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        //int[][] matrix = {{1, 1}, {1, 1}};
        Solution solution = new Solution();
        List<int[]> result = solution.pacificAtlantic(matrix);
        result.forEach((int[] xs) -> {
            for (int x : xs) {
                System.out.print(x + ", ");
            }
            System.out.println();
        });
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return Collections.emptyList();
        }

        int n = matrix[0].length;
        if (n == 0) {
            return Collections.emptyList();
        }

        int[][] result = new int[m][n];
        boolean[] checked = new boolean[m * n];
        flow(matrix, m, n, -1, result, 1, checked);
        flow(matrix, m, n, m * n, result, 2, checked);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 3) {
                    list.add(new int[] {i, j});
                }
            }
        }
        return list;
    }

    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    private void flow(int[][] matrix, int m, int n, int from, int[][] result, int r, boolean[] checked) {
        PriorityQueue<Cell> queue = new PriorityQueue<>((Cell a, Cell b) -> {
            int cmp = matrix[a.x][a.y] - matrix[b.x][b.y];
            if (cmp != 0) {
                return cmp;
            }
            cmp = a.x - b.x;
            if (cmp != 0) {
                return cmp;
            }
            return a.y - b.y;
        });

        Arrays.fill(checked, false);

        if (from == -1) {
            queue.offer(new Cell(0, 0));
            checked[0] = true;
            for (int i = 1; i < m; i++) {
                queue.offer(new Cell(i, 0));
                checked[i * n] = true;
            }
            for (int j = 1; j < n; j++) {
                queue.offer(new Cell(0, j));
                checked[j] = true;
            }
        } else {
            queue.offer(new Cell(m - 1, n - 1));
            checked[m * n - 1] = true;
            for (int i = 0; i < m - 1; i++) {
                queue.offer(new Cell(i, n - 1));
                checked[i * n + n - 1] = true;
            }
            for (int j = 0; j < n - 1; j++) {
                queue.offer(new Cell(m - 1, j));
                checked[(m - 1) * n + j] = true;
            }
        }

        while (!queue.isEmpty()) {
            //int[] v = queue.poll();
            Cell v = queue.poll();
            int i = v.x;
            int j = v.y;
            int h = matrix[i][j];
            result[i][j] |= r;

            for (int k = 0; k < dx.length; k++) {
                int a = dx[k] + i;
                int b = dy[k] + j;
                if (a < 0 || a == m || b < 0 || b == n || checked[a * n + b] || matrix[a][b] < h) {
                    continue;
                }

                queue.add(new Cell(a, b));
                checked[a * n + b] = true;

            }
        }
    }

    static class Cell {
        final int x;
        final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

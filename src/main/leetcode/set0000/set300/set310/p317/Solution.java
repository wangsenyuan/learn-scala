package set0000.set300.set310.p317;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangsenyuan on 03/11/2016.
 */
public class Solution {

    private int[] direct = {-1, 0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int M = grid.length;
        int N = (M == 0) ? 0 : grid[0].length;
        int[][] marked = new int[M][N];
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    bfs(q, grid, marked, cnt++);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (marked[i][j] == cnt) {
                    min = Math.min(min, -grid[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs(Queue<int[]> q, int[][] grid, int[][] marked, int cnt) {
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                for (int j = 0; j < 4; j++) {
                    int nextR = r + direct[j];
                    int nextC = c + direct[j + 1];
                    if (nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length
                        && grid[nextR][nextC] <= 0 && marked[nextR][nextC] == cnt) {
                        marked[nextR][nextC]++;
                        q.offer(new int[] {nextR, nextC});
                        grid[nextR][nextC] -= dist;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid =
            {{1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}};

        Solution solution = new Solution();
        System.out.println(solution.shortestDistance(grid));
    }
}

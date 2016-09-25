package p407;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 9/25/16.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] height = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int[][] height = {{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}};
        //int[][] height = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        System.out.println(solution.trapRainWater(height));
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m <= 2) {
            return 0;
        }
        int n = heightMap[0].length;
        if (n <= 2) {
            return 0;
        }
        int[][] capacity = new int[m][n];

        for (int i = 1; i < m - 1; i++) {
            calculateCapacity(heightMap, capacity, i, 0, 0);
            calculateCapacity(heightMap, capacity, i, n - 1, 0);
        }

        for (int i = 1; i < n - 1; i++) {
            calculateCapacity(heightMap, capacity, 0, i, 0);
            calculateCapacity(heightMap, capacity, m - 1, i, 0);
        }

        int v = 0;

        for (int a = 1; a < m - 1; a++) {
            int[] cp = capacity[a];
            int[] height = heightMap[a];
            for (int i = 0, j = n - 1; i < j; ) {
                if (height[i] <= height[j]) {
                    int k = i + 1;
                    for (; height[i] > height[k]; k++) {
                        int u = min(height[i], cp[k]) - height[k];
                        if (u > 0) {
                            v += u;
                        }
                    }
                    i = k;
                } else {
                    int k = j - 1;
                    for (; height[j] > height[k]; k--) {
                        int u = min(height[j], cp[k]) - height[k];
                        if (u > 0) {
                            v += u;
                        }
                    }
                    j = k;
                }
            }
        }
        return v;
    }

    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    private int calculateCapacity(int[][] height, int[][] capacity, int i, int j, int cap) {
        int y = cap;
        for (int k = 0; k < dx.length; k++) {
            int a = i + dx[k];
            int b = j + dy[k];
            if (a < 0 || a >= capacity.length || b < 0 || b >= capacity[a].length) {
                continue;
            }

            if (height[i][j] > height[a][b]) {
                int x = calculateCapacity(height, capacity, a, b, max(height[i][j], y));
                if (y < 0 || x < y) {
                    y = x;
                }
            }
        }

        if (capacity[i][j] > 0) {
            capacity[i][j] = min(capacity[i][j], y);
        } else {
            capacity[i][j] = y;
        }
        return y;
    }

    int min(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }
}

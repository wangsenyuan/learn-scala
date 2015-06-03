package p221.max.square;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by senyuanwang on 15/6/3.
 */
public class Solution {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] sum = new int[m + 1][n + 1];

        sum[1][1] = matrix[0][0] == '1' ? 1 : 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (matrix[i - 1][j - 1] == '1' ? 1 : 0);
            }
        }
        int lb = 0;
        int up = Math.min(m, n) * 2;
        int res = 0;
        while (lb <= up) {
            int mid = (lb + up) / 2;
            if (check(sum, m, n, mid, mid)) {
                res = mid;
                lb = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        return res * res;
    }

    private static boolean check(int[][] sum, int m, int n, int x, int y) {
        for (int i = 0; i + x <= m; i++) {
            for (int j = 0; j + y <= n; j++) {
                int area = sum[i + x][j + y] + sum[i][j] - sum[i + x][j] - sum[i][j + y];
                if (area == x * y) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src/main/leetcode/p221/max/square/test.2.txt"))) {
            List<String[]> list = lines.map(str -> str.split("\\s+")).collect(Collectors.toList());
            char[][] matrix = new char[list.size()][list.get(0).length];
            for (int i = 0; i < list.size(); i++) {
                String[] strings = list.get(i);
                for (int j = 0; j < strings.length; j++) {
                    matrix[i][j] = strings[j].charAt(0);
                }
            }
            System.out.println(maximalSquare(matrix));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

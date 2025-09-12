package codeforces.set2041.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }


    private static final long INF = 1L << 60;

    public long solve(int n, int[][][] layers) {
        int N = 1 << n;
        // 创建DP数组
        long[][] dp = new long[N][N];

        // 初始化DP数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;

        // 对每一层进行处理
        for (int[][] cur : layers) {
            // 从后向前遍历状态，避免状态污染
            for (int s1 = N - 1; s1 >= 0; s1--) {
                for (int s2 = N - 1; s2 >= 0; s2--) {
                    // 检查两个状态中1的数量是否相等
                    if (Integer.bitCount(s1) == Integer.bitCount(s2)) {
                        // 遍历所有可能的位置
                        for (int y = 0; y < n; y++) {
                            if ((s1 >> y & 1) == 1) {
                                for (int z = 0; z < n; z++) {
                                    if ((s2 >> z & 1) == 1) {
                                        // 状态转移
                                        int prevS1 = s1 ^ (1 << y);
                                        int prevS2 = s2 ^ (1 << z);
                                        dp[s1][s2] = Math.min(dp[s1][s2], dp[prevS1][prevS2] + cur[y][z]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 检查结果是否有效
        return dp[N - 1][N - 1];
    }

    // 用于测试的主方法
    public static void main(String[] args) {
        Main solution = new Main();
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int[][][] layers = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    layers[i][j][k] = reader.nextInt();
                }
            }
        }
        long res = solution.solve(n, layers);
        System.out.println(res);
    }
}

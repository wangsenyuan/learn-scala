package codechef.medium.kol15b;

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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    static int MAX_N = 1000;

    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] A = new int[MAX_N][MAX_N];
    static int[][] B = new int[MAX_N][MAX_N];
    static int[][] C = new int[MAX_N][MAX_N];
    static int[][] D = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = reader.nextInt();
                }
            }
            System.out.println(solve(n, m));
        }
    }

    private static int solve(int n, int m) {
        calculateRowBestFromLeft(n, m);
        calculateRowBestFromRight(n, m);
        calculateColBestFromTop(n, m);
        calculateColBestFromBottom(n, m);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = A[i][j] + B[i][j] + C[i][j] + D[i][j] - 3 * grid[i][j];
                if (tmp < ans) {
                    ans = tmp;
                }
            }
        }

        return ans;
    }

    private static void calculateRowBestFromLeft(int n, int m) {

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                A[i][j] = grid[i][j];
                if (j > 0 && A[i][j - 1] < 0) {
                    A[i][j] += A[i][j - 1];
                }
            }
        }
    }


    private static void calculateRowBestFromRight(int n, int m) {
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                B[i][j] = grid[i][j];
                if (j < m - 1 && B[i][j + 1] < 0) {
                    B[i][j] += B[i][j + 1];
                }
            }
        }
    }


    private static void calculateColBestFromTop(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = grid[i][j];
                if (i > 0 && C[i - 1][j] < 0) {
                    C[i][j] += C[i - 1][j];
                }
            }
        }
    }


    private static void calculateColBestFromBottom(int n, int m) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                D[i][j] = grid[i][j];
                if (i < n - 1 && D[i + 1][j] < 0) {
                    D[i][j] += D[i + 1][j];
                }
            }
        }
    }

}

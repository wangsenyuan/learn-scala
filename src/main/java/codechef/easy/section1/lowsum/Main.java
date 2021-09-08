package codechef.easy.section1.lowsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int q = reader.nextInt();
            long[] A = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextLong();
            }
            long[] B = new long[n];
            for (int i = 0; i < n; i++) {
                B[i] = reader.nextLong();
            }
            int[] Q = new int[q];
            for (int i = 0; i < q; i++) {
                Q[i] = reader.nextInt();
            }
            long[] res = solve(A, B, Q);
            StringBuilder buf = new StringBuilder();

            for (int i = 0; i < q; i++) {
                buf.append(res[i]);
                buf.append('\n');
            }

            System.out.print(buf);
        }

    }

    private static long[] solve(long[] A, long[] B, int[] Q) {
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        long[] ans = new long[Q.length];
        for (int i = 0; i < Q.length; i++) {
            int cnt = Q[i];
            long left = 0;
            long right = A[n - 1] + B[n - 1];
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (count(A, B, mid) >= cnt) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = right;
        }

        return ans;
    }

    private static int count(long[] A, long[] B, long num) {
        int row = 0;
        int col = B.length - 1;
        int cnt = 0;
        while (row < A.length && col >= 0) {
            long tmp = A[row] + B[col];
            if (tmp <= num) {
                cnt += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return cnt;
    }

}

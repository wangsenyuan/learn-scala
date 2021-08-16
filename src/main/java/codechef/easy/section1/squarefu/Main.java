package codechef.easy.section1.squarefu;

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
        init();
        StringBuilder buf = new StringBuilder();
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            long res = solve(A);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf);
    }


    private final static int X = 1000010;

    private final static int[] F = new int[X];
    private final static int[] dd = new int[X];
    private final static int[] cnt = new int[X];

    private static void init() {
        for (int i = 2; i < X; i++) {
            if (F[i] == 0) {
                F[i] = i;
                for (long j = 1l * i * i; j < X; j += i) {
                    if (F[(int) j] == 0) {
                        F[(int) j] = i;
                    }
                }
            }
        }
    }

    private static long solve(int[] A) {
        Arrays.fill(cnt, 0);
        long res = 1l * A.length * (A.length - 1) / 2;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            while (cur > 1) {
                dd[F[cur]] ^= 1;
                cur /= F[cur];
            }
            int num = 1;
            cur = A[i];
            while (cur > 1) {
                if (dd[F[cur]] == 1) {
                    num *= F[cur];
                    dd[F[cur]] = 0;
                }
                cur /= F[cur];
            }
            res -= cnt[num];
            cnt[num]++;
        }

        return res;
    }
}

package codechef.easy.amboxes;

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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = reader.nextInt();
        }

        long[] xs = new long[m];
        for (int i = 0; i < m; i++) {
            xs[i] = reader.nextLong();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(solve(xs[i], n, as));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int solve(long x, int n, int[] as) {
        int ans = 0;
        int i = 0;

        while (x > as[i]) {
            x = (x + as[i] - 1) / as[i];
            ans += x;
            i++;
        }

        return ans + n - i;
    }
}

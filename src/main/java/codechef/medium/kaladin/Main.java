package codechef.medium.kaladin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextInt();
        }
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < n; i++) {
            double res = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                res += (double) A[j] / (double) (A[i] + A[j]);
            }
            buf.append(String.format("%.6f ", res));
        }
        System.out.println(buf.toString());
    }

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
}

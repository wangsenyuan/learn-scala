package codechef.easy.optcode;

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

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int[] X = new int[n];
            int[] Y = new int[n];
            for (int i = 0; i < n; i++) {
                X[i] = reader.nextInt();
                Y[i] = reader.nextInt();
            }
            System.out.println(solve(n, X, Y));
        }
    }

    private static int solve(int n, int[] X, int[] Y) {
        int y1 = 0;
        for (int i = 1; i < n; i++) {
            if (Y[i] > Y[y1]) {
                y1 = i;
            }
        }

        int y2 = -1;
        for (int i = 0; i < n; i++) {
            if (X[i] != X[y1] && (y2 < 0 || (Y[y2] < Y[i]))) {
                y2 = i;
            }
        }
        if (y2 < 0) {
            return 0;
        }

        int y3 = -1;
        for (int i = 0; i < n; i++) {
            if (X[i] != X[y1] && X[i] != X[y2] && (y3 < 0 || Y[y3] < Y[i])) {
                y3 = i;
            }
        }
        if (y3 < 0) {
            return 0;
        }
        return Y[y1] + Y[y2] + Y[y3];
    }
}

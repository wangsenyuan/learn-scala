package codechef.easy.talesqua;

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
        int t = reader.nextInt();
        while (t-- > 0) {
            int a = reader.nextInt();
            int k = reader.nextInt();
            int x1 = reader.nextInt();
            int x2 = reader.nextInt();
            int x3 = reader.nextInt();
            double res = solve(a, k, x1, x2, x3);
            System.out.printf("%.3f\n", res);
        }
    }

    public static double solve(int a, int k, int x1, int x2, int x3) {
        int x = min(x1, x2, x3);
        int y = max(x1, x2, x3);

        if (y - x >= 2 * k + a) {
            return 0;
        }
        if (y - x <= 2 * k) {
            return a * a;
        }
        return (2 * k + a + x - y) * a;
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }

        if (b < a && b < c) {
            return b;
        }
        return c;
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        if (b > a && b > c) {
            return b;
        }
        return c;
    }
}

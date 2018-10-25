package codechef.easy.section1.laughmen;

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
            int n = reader.nextInt();
            int[] J = new int[n];
            for (int i = 0; i < n; i++) {
                J[i] = reader.nextInt();
            }
            int[] L = new int[n];
            for (int i = 0; i < n; i++) {
                L[i] = reader.nextInt();
            }

            if (solve(n, J, L)) {
                System.out.println("#laughing_arjun");
            } else {
                System.out.println("#itsnot_arjun");
            }
        }
    }

    public static boolean solve(int n, int[] J, int[] L) {
        int[] ar = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (J[i] < 0) {
                continue;
            }
            ar[p++] = L[i];
        }

        int c = 0;
        int d = 0;

        for (int i = 0; i < p - 2; i++) {
            if (ar[i] > ar[i + 2]) {
                c++;
            }
        }

        for (int i = 0; i < p - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                d++;
            }
        }

        return c <= 1 && d <= 1;
    }
}

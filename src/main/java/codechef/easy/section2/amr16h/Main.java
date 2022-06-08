package codechef.easy.section2.amr16h;

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

        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            Arrays.sort(A);
            long sum = 0;
            long res = 0;
            for (int i = n - 2; i >= 0; i--) {
                sum += A[i];
                res += sum;
            }
            sum += A[n - 1];
            res += sum;
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf);
    }

}

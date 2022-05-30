package codechef.easy.section2.chn08;


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
        int tc = reader.nextInt();

        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int n = reader.nextInt();
            int res = solve(a, b, n);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf);
    }

    private static int solve(int a, int b, int n) {
        a = modRound(a);
        b = modRound(b);
        int[] arr = {a, b, modSub(b, a), modSub(0, a), modSub(0, b), modSub(a, b)};

        n %= 6;
        if (n == 0) {
            n = 6;
        }
        n--;
        return arr[n];
    }

    private static final int MOD = 1000000007;

    private static int modAdd(int a, int b) {
        a += b;
        if (a >= MOD) {
            a -= MOD;
        }
        return a;
    }

    private static int modSub(int a, int b) {
        return modAdd(a, MOD - b);
    }

    private static int modRound(int a) {
        a %= MOD;
        if (a < 0) {
            a += MOD;
        }
        return a;
    }
}

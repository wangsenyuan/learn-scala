package codechef.medium.kol16a;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();

        int tc = fastReader.nextInt();

        StringBuilder buf = new StringBuilder();

        for (int tt = 1; tt <= tc; tt++) {
            int n = fastReader.nextInt();
            double[] P = new double[n];

            for (int i = 0; i < n; i++) {
                P[i] = Double.parseDouble(fastReader.next());
            }
            int[] F = new int[n];
            for (int i = 0; i < n; i++) {
                F[i] = fastReader.nextInt();
            }
            double S = Double.parseDouble(fastReader.next());
            int res = solve(S, P, F);
            buf.append(String.format("Case %d: %d\n", tt, res));
        }

        System.out.print(buf.toString());
    }

    public static int solve(double threshold, double[] P, int[] F) {
        int n = P.length;
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            pp[i] = (int) (P[i] * 100);
        }
        int S = (int) (threshold * 100);

        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        return f(dp, pp, F, n, S, 0, 0);
    }

    private static int f(Map<Integer, Integer>[] dp, int[] P, int[] F, int n, int S, int i, int t) {
        if (i == n) {
            return 0;
        }

        if (dp[i].containsKey(t)) {
            return dp[i].get(t);
        }
        int win = 0;
        if (t + 100 - P[i] < S * (i + 1)) {
            win = F[i] + f(dp, P, F, n, S, i + 1, t + 100 - P[i]);
        }
        int lose = f(dp, P, F, n, S, i + 1, t - P[i]);
        int res = Math.max(win, lose);
        dp[i].put(t, res);
        return res;
    }


}

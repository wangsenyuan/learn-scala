package codechef.easy.section1.nextnum;

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
        init();
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            String s = reader.nextLine();
            long res = solve(s);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf);
    }

    private static final int N = 19;
    private static long[] P = new long[N];

    private static void init() {
        P[0] = 1;
        for (int i = 1; i < N; i++) {
            P[i] = P[i - 1] * i;
        }
    }

    private static long solve(String s) {
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            for (int y = 0; y < x; y++) {
                if (cnt[y] > 0) {
                    cnt[y]--;
                    res += count(cnt);
                    cnt[y]++;
                }
            }
            cnt[x]--;
        }
        return res + 1;
    }

    private static long count(int[] cnt) {
        int tot = 0;
        for (int i = 0; i < 10; i++) {
            tot += cnt[i];
        }
        long ans = P[tot];
        for (int i = 0; i < 10; i++) {
            ans /= P[cnt[i]];
        }

        return ans;
    }
}

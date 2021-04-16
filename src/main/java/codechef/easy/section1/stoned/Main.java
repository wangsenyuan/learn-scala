package codechef.easy.section1.stoned;

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
        StringBuilder buf = new StringBuilder();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[] H = new int[n];
            for (int i = 0; i < n; i++) {
                H[i] = reader.nextInt();
            }
            int[][] Q = new int[m][2];
            for (int i = 0; i < m; i++) {
                Q[i][0] = reader.nextInt();
                Q[i][1] = reader.nextInt();
            }
            int[] res = solve(H, Q);
            for (int i = 0; i < m; i++) {
                buf.append(res[i]);
                buf.append('\n');
            }
        }
        System.out.print(buf.toString());
    }

    private static int[] solve(int[] H, int[][] Q) {
        int n = H.length;
        int[] stack = new int[n];
        int[][] P = new int[n + 1][20];
        int p = 0;
        int[] D = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            while (p > 0 && H[stack[p - 1]] <= H[i]) {
                p--;
            }
            if (p == 0) {
                P[i][0] = n;
            } else {
                P[i][0] = stack[p - 1];
            }
            D[i] = D[P[i][0]] + 1;
            stack[p] = i;
            p++;
        }
        int[] res = new int[Q.length];

        for (int i = 0; i < Q.length; i++) {
            int u = Q[i][0];
            int v = Q[i][1];
            u--;
            v--;
            if (u > v) {
                u ^= v;
                v ^= u;
                u ^= v;
            }
            int x = lca(D, P, u, v);
            res[i] = D[x];
            if (x == v) {
                res[i]--;
            }
        }
        return res;

    }

    private static int lca(int[] D, int[][] P, int u, int v) {
        if (D[u] < D[v]) {
            u ^= v;
            v ^= u;
            u ^= v;
        }
        for (int i = 19; i >= 0; i--) {
            if (D[u] - (1 << i) >= D[v]) {
                u = P[u][i];
            }
        }
        if (u == v) {
            return u;
        }
        for (int i = 19; i >= 0; i--) {
            if (P[u][i] != P[v][i]) {
                u = P[u][i];
                v = P[v][i];
            }
        }
        return P[u][0];
    }

    private static int[] solve1(int[] H, int[][] Q) {
        int n = H.length;
        int[] arr = new int[2 * n];
        for (int i = n; i < 2 * n; i++) {
            arr[i] = i - n;
        }
        for (int i = n - 1; i > 0; i--) {
            if (H[arr[i * 2]] > H[arr[i * 2 + 1]]) {
                arr[i] = arr[i * 2];
            } else {
                arr[i] = arr[i * 2 + 1];
            }
        }

        int[] stack = new int[n];
        int p = 0;

        int[] cnt = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (p > 0 && H[stack[p - 1]] <= H[i]) {
                p--;
            }
            if (p > 0) {
                cnt[i] = cnt[stack[p - 1]] + 1;
            }
            stack[p] = i;
            p++;
        }

        int[] res = new int[Q.length];

        for (int i = 0; i < Q.length; i++) {
            int u = Q[i][0];
            int v = Q[i][1];
            u--;
            v--;
            if (u > v) {
                u ^= v;
                v ^= u;
                u ^= v;
            }
            int x = find(H, arr, u, v + 1);
            res[i] = cnt[x];
        }
        return res;
    }

    private static int find(int[] H, int[] arr, int l, int r) {
        int n = H.length;
        l += n;
        r += n;
        int res = -1;
        int hh = 0;
        while (l < r) {
            if ((l & 1) == 1) {
                if (H[arr[l]] > hh) {
                    hh = H[arr[l]];
                    res = l;
                }
                l++;
            }
            if ((r & 1) == 1) {
                r--;
                if (H[arr[r]] > hh) {
                    hh = H[arr[r]];
                    res = r;
                }
            }
            l >>= 1;
            r >>= 1;
        }
        return arr[res];
    }
}

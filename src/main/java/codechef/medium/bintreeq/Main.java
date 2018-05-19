package codechef.medium.bintreeq;

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
            int u = reader.nextInt();
            int v = reader.nextInt();
            System.out.println(solve(n, u, v));
        }
    }

    public static int solve(int n, int u, int v) {
        int L = lca(u, v);
        int[] pu = find(L, u);
        int[] pv = find(L, v);

        int lo = 1;
        int hi = n + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(pu, pv, mid, n)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo - 1;
    }

    private static boolean check(int[] pu, int[] pv, int x, int n) {
        long w = apply(x, pu);
        if (w > n) {
            return false;
        }

        long t = apply(x, pv);
        if (t > n) {
            return false;
        }

        return true;
    }

    private static long apply(int x, int[] p) {
        long y = x;
        for (int i = 0; i < p.length && p[i] >= 0; i++) {
            y = (y << 1) | p[i];
        }
        return y;
    }

    private static int[] find(int l, int u) {
        int[] res = new int[32];

        int p = 0;
        while (u != l) {
            res[p++] = u & 1;
            u >>= 1;
        }

        for (int i = 0, j = p - 1; i < j; i++, j--) {
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
        }

        res[p] = -1;
        return res;
    }

    private static int lca(int u, int v) {
        while (u != v) {
            if (u > v) {
                u >>= 1;
            } else {
                v >>= 1;
            }
        }
        return u;
    }
}

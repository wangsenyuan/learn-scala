package codechef.easy.section1.risk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
            int m = reader.nextInt();
            byte[][] B = new byte[n][];
            for (int i = 0; i < n; i++) {
                B[i] = reader.next().getBytes();
            }
            int res = solve(B);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf);
    }

    private static int solve(byte[][] B) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[][] vis = new boolean[B.length][B[0].length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] == '1' && !vis[i][j]) {
                    vis[i][j] = true;
                    int cnt = dfs(B, i, j, vis);
                    res.add(cnt);
                }
            }
        }

        Collections.sort(res);

        int ans = 0;
        for (int i = res.size() - 2; i >= 0; i -= 2) {
            ans += res.get(i);
        }
        return ans;
    }

    private static final int[] dd = {-1, 0, 1, 0, -1};

    private static int dfs(byte[][] B, int u, int v, boolean[][] vis) {
        int res = 1;

        for (int k = 0; k < 4; k++) {
            int x = u + dd[k];
            int y = v + dd[k + 1];
            if (x >= 0 && x < B.length && y >= 0 && y < B[0].length && B[x][y] == '1' && !vis[x][y]) {
                vis[x][y] = true;
                res += dfs(B, x, y, vis);
            }
        }

        return res;
    }
}

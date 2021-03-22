package codechef.easy.section1.warta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
    }


    final static int MOD = 1000000007;
    final static int INF = 1 << 30;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int m = reader.nextInt();
            int n = reader.nextInt();
            int k = reader.nextInt();
            int[][] A = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = reader.nextInt();
                }
            }
            String[] D = new String[m];
            for (int i = 0; i < m; i++) {
                D[i] = reader.next();
            }
            int res = solve(k, A, D);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    final static int[] dx = {-1, 0, 1, 0, -1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1, 0, 1, 0, -1};


    static class Pair implements Comparable<Pair> {
        final int first;
        final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.first != that.first) {
                if (this.first < that.first) {
                    return -1;
                }
                if (this.first > that.first) {
                    return 1;
                }
            }
            if (this.second < that.second) {
                return -1;
            }
            return 1;
        }
    }

    public static int solve(int k, int[][] A, String[] D) {
        int m = A.length;
        int n = A[0].length;
        int[][] dist = new int[m][n];

        int left = 0;
        int right = MOD;

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(m, n, k, A, dist, D, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return Math.max(0, right - 1);
    }

    private static boolean check(int m, int n, int k, int[][] A, int[][] dist, String[] D, int X) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }

        dist[0][0] = 0;
        TreeSet<Pair> tree = new TreeSet<>();
        tree.add(new Pair(0, 0));

        while (tree.size() > 0) {
            Pair cur = tree.pollFirst();
            int x = cur.second / n;
            int y = cur.second % n;
            if (dist[x][y] < cur.first) {
                continue;
            }
            int j = getDir(D[x].charAt(y));
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[j + i];
                int ny = y + dy[j + i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && A[x][y] - i >= X && dist[nx][ny] > cur.first + i) {
                    dist[nx][ny] = cur.first + i;
                    tree.add(new Pair(dist[nx][ny], nx * n + ny));
                }
            }
        }

        return dist[m - 1][n - 1] <= k;
    }

    private static int getDir(char x) {
        if (x == 'U') {
            return 0;
        }
        if (x == 'R') {
            return 1;
        }
        if (x == 'D') {
            return 2;
        }
        return 3;
    }
}

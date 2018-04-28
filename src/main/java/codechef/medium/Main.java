package codechef.medium;

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
        FastReader fastReader = new FastReader();
        int t = fastReader.nextInt();

        while (t-- > 0) {
            int n = fastReader.nextInt();
            int[] diff = new int[26];
            int[][] grid = new int[26][26];
            boolean[] seen = new boolean[26];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                String line = fastReader.nextLine();
                char a = line.charAt(0);
                char b = line.charAt(line.length() - 1);
                diff[a - 'a']--;
                diff[b - 'a']++;
                if (!seen[a - 'a']) {
                    seen[a - 'a'] = true;
                    cnt++;
                }

                if (!seen[b - 'a']) {
                    seen[b - 'a'] = true;
                    cnt++;
                }
                grid[a - 'a'][b - 'a']++;
            }

            boolean res = solve(diff, grid, cnt);
            if (res) {
                System.out.println("Ordering is possible.");
            } else {
                System.out.println("The door cannot be opened.");
            }
        }
    }

    private static boolean solve(int[] diff, int[][] grid, int cnt) {
        boolean connected = false;

        for (int i = 0; i < 26; i++) {
            boolean[] seen = new boolean[26];
            int tmp = bfs(grid, i, seen);
            if (cnt == tmp) {
                connected = true;
                break;
            }
        }

        if (!connected) {
            return false;
        }


        int x = -1;
        int y = -1;
        for (int i = 0; i < 26; i++) {
            if (diff[i] == 0) {
                continue;
            }

            if (diff[i] > 1 || diff[i] < -1) {
                return false;
            }

            if (diff[i] == 1) {
                if (x >= 0) {
                    return false;
                }
                x = i;
            } else {
                if (y >= 0) {
                    return false;
                }
                y = i;
            }
        }

        if (x < 0 && y < 0) {
            return true;
        }
        if (x >= 0 && y >= 0) {
            return true;
        }
        return false;
    }

    private static int bfs(int[][] grid, int i, boolean[] seen) {
        int[] que = new int[26];
        int front = 0;
        int tail = 0;
        que[tail++] = i;
        seen[i] = true;

        while (front < tail) {
            int tt = tail;
            while (front < tt) {
                int u = que[front++];
                for (int v = 0; v < 26; v++) {
                    if (!seen[v] && grid[u][v] > 0) {
                        que[tail++] = v;
                        seen[v] = true;
                    }
                }
            }
        }

        return tail;
    }

    private static int dfs(int[][] grid, int u, boolean[] seen) {
        if (seen[u]) {
            return 0;
        }
        seen[u] = true;
        int ans = 0;
        for (int v = 0; v < 26; v++) {
            if (!seen[v] && grid[u][v] > 0) {
                ans += dfs(grid, v, seen);
            }
        }
        return ans + 1;
    }


}

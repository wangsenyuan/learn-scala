package codechef.easy.clklzm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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
            int m = reader.nextInt();
            int[] Z = new int[n];
            for (int i = 0; i < n; i++) {
                Z[i] = reader.nextInt();
            }
            Crane[] cranes = new Crane[m];
            for (int i = 0; i < m; i++) {
                int left = reader.nextInt() - 1;
                int right = reader.nextInt() - 1;
                int k = reader.nextInt();
                cranes[i] = new Crane(left, right, k);
            }
            int res = solve(n, m, Z, cranes);
            if (res < 0) {
                System.out.println("NO");
            } else {
                System.out.printf("YES %d\n", res);
            }
        }
    }

    public static int solve(int n, int m, int[] Z, Crane[] cranes) {
        Arrays.sort(cranes, Comparator.comparingInt(a -> a.left));

        PriorityQueue<Crane> h = new PriorityQueue<>(Comparator.comparing((Crane a) -> a.right).reversed());
        int ans = 0;
        int[] diff = new int[n + 1];
        for (int i = 0, j = 0; i < n; ) {
            if (Z[i] + diff[i] > 0) {
                while (j < m && cranes[j].left <= i) {
                    h.offer(cranes[j]);
                    j++;
                }
                if (h.isEmpty() || h.peek().right < i) {
                    return -1;
                }

                Crane pick = h.poll();
                int tmp = Math.min(Z[i] + diff[i], pick.beams);
                diff[i] -= tmp;
                diff[pick.right + 1] += tmp;
                pick.beams -= tmp;
                if (pick.beams > 0) {
                    h.offer(pick);
                }
                ans += tmp;
            }

            if (Z[i] + diff[i] <= 0) {
                diff[i + 1] += diff[i];
                i++;
            }
        }

        return ans;
    }

    static class Crane {
        final int left;
        final int right;
        int beams;

        public Crane(int left, int right, int beams) {
            this.left = left;
            this.right = right;
            this.beams = beams;
        }
    }
}

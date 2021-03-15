package codechef.medium.kol16k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[][] P = new int[n][2];
            for (int i = 0; i < n; i++) {
                P[i][0] = reader.nextInt();
                P[i][1] = reader.nextInt();
            }
            int res = solve(P);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    private static final double D_INF = 1e12;

    public static int solve(int[][] P) {
        Arrays.sort(P, (int[] a, int[] b) -> {
            if (a[0] < b[0]) {
                return -1;
            }
            if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });
        int n = P.length;
        ArrayList<Pair>[] C = new ArrayList[n + 1];
        ArrayList<Integer>[] S = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            C[i] = new ArrayList<>();
            S[i] = new ArrayList<>();
        }
        C[0].add(new Pair(D_INF, 1));
        S[0].add(1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            double x1 = P[i][0];
            double y1 = P[i][1];
            for (int j = 0; j < i; j++) {
                double x2 = P[j][0];
                double y2 = P[j][1];
                double c = (y1 - y2) / (x1 - x2);
                int k = search(C[j], c);
                ans = Math.max(ans, S[j].get(k) + 1);
                C[i].add(new Pair(c, S[j].get(k) + 1));
            }
            C[i].add(new Pair(D_INF, 1));
            Collections.sort(C[i]);
            for (Pair c : C[i]) {
                S[i].add(c.second);
            }

            for (int j = S[i].size() - 2; j >= 0; j--) {
                S[i].set(j, Math.max(S[i].get(j), S[i].get(j + 1)));
            }
        }
        return ans;
    }

    private static int search(ArrayList<Pair> arr, double target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid).first >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static class Pair implements Comparable<Pair> {
        private final double first;
        private final int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.first < that.first) {
                return -1;
            }
            if (this.first > that.first) {
                return 1;
            }
            return 0;
        }
    }
}

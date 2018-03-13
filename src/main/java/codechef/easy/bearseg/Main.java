package codechef.easy.bearseg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
            int p = reader.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            solve(n, p, A);
        }
    }

    public static void solve(int n, int p, int[] A) {
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = (sum[i] + A[i]) % p;
        }

        TreeMap<Long, Integer> map = new TreeMap<>();

        long best = sum[0];
        int cnt = 1;
        long tmp = 0;
        map.put(sum[0], 1);
        for (int i = 1; i <= n; i++) {
            long x = sum[i];
            Map.Entry<Long, Integer> gt = map.ceilingEntry(x + 1);
            if (gt == null) {
                gt = map.firstEntry();
            }
            long y = gt.getKey();
            int yc = gt.getValue();
            tmp = (x - y + p) % p;
            if (tmp > best) {
                best = tmp;
                cnt = 0;
            }
            if (tmp == best) {
                cnt += yc;
            }
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        System.out.printf("%d %d", best, cnt);
    }


}

package codechef.easy.section1.ticketqu;

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


    static class Deque {
        private final int[] arr;
        private int front;
        private int end;

        public Deque(int n) {
            this.arr = new int[n + 1];
            this.front = 0;
            this.end = 0;
        }

        public void pushBack(int v) {
            arr[this.end] = v;
            this.end = (this.end + 1) % arr.length;
        }

        public int popFront() {
            int res = this.arr[this.front];
            this.front = (this.front + 1) % arr.length;
            return res;
        }

        public boolean isEmpty() {
            return this.front == this.end;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] X = new int[n];
            for (int i = 0; i < n; i++) {
                X[i] = reader.nextInt();
            }
            int[] ans = solve(n, X);
            for (int i = 0; i < n; i++) {
                buf.append(ans[i]);
                buf.append(' ');
            }
            buf.append('\n');
        }
        System.out.print(buf);
    }

    public static int[] solve(int n, int[] X) {
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cnt[X[i]]++;
        }

        Deque[] dqs = new Deque[n + 1];

        for (int i = 1; i <= n; i++) {
            dqs[i] = new Deque(cnt[i]);
        }

        TreeMap<Integer, Boolean> set = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            set.put(X[i], true);
            dqs[X[i]].pushBack(i);
        }
        int[] ans = new int[n];
        int seat = 1;
        while (!set.isEmpty()) {
            // need to find the least x, that is <= seat
            Map.Entry<Integer, Boolean> cand = set.floorEntry(seat);
            if (cand != null) {
                int num = cand.getKey();
                int i = dqs[num].popFront();
                ans[i] = seat;
                if (dqs[num].isEmpty()) {
                    set.remove(num);
                }
            }

            seat++;
        }

        return ans;
    }
}

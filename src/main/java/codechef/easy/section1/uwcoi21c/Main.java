package codechef.easy.section1.uwcoi21c;

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

        while (tc-- > 0) {
            solve(reader);
        }
    }

    public static void solve(FastReader reader) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        TreeSet<Pair> set = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            int x = reader.nextInt();
            Pair pair = new Pair(x, i);
            set.add(pair);
        }

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Pair a = set.pollFirst();
            buf.append(String.format("%d %d ", a.second, a.first));
            Pair b = set.pollLast();
            buf.append(String.format("%d %d\n", b.second, k - a.first));
            Pair c = new Pair(b.first - (k - a.first), b.second);
            set.add(c);
        }
        System.out.print(buf.toString());
    }

    static class Pair implements Comparable<Pair> {
        final int first;
        final int second;

        Pair(int first, int second) {
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
            if (this.second < that.second) {
                return -1;
            }
            return 1;
        }
    }
}

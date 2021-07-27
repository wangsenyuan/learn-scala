package codechef.easy.section1.maxswt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Predicate;

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
            int d = reader.nextInt();
            int[] P = new int[n];
            for (int i = 0; i < n; i++) {
                P[i] = reader.nextInt();
            }
            int[] S = new int[n];
            for (int i = 0; i < n; i++) {
                S[i] = reader.nextInt();
            }
            int res = solve(n, d, P, S);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    public static int solve(int n, long d, int[] P, int[] S) {
        final Candy[] candies = new Candy[n];
        for (int i = 0; i < n; i++) {
            candies[i] = new Candy(P[i], S[i]);
        }

        Arrays.sort(candies);

        int best = 0;
        int[] good = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = candies[i].price;
            if (cur <= d) {
                best = Math.max(best, candies[i].sweet);
            }
            if (i == 0) {
                good[i] = candies[i].sweet;
            } else {
                int j = binarySearch(i, k -> cur + candies[k].price > d);
                j--;
                if (j >= 0) {
                    best = Math.max(best, good[j] + candies[i].sweet);
                }
                good[i] = Math.max(good[i - 1], candies[i].sweet);
            }
        }

        return best;
    }

    static class Candy implements Comparable<Candy> {
        final int price;
        final int sweet;

        Candy(int price, int sweet) {
            this.price = price;
            this.sweet = sweet;
        }

        @Override
        public int compareTo(Candy that) {
            if (this.price < that.price) {
                return -1;
            }
            if (this.price > that.price) {
                return 1;
            }
            return 0;
        }
    }

    public static int binarySearch(int n, Predicate<Integer> fn) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (fn.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

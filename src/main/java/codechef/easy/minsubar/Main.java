package codechef.easy.minsubar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        FastReader fastReader = new FastReader();
        int t = fastReader.nextInt();
        while (t-- > 0) {
            int n = fastReader.nextInt();
            long d = fastReader.nextLong();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = fastReader.nextInt();
            }
            int res = solve(n, d, A);
            if (res == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(res);
            }
        }
    }

    public static int solve(int n, long d, int[] A) {
        long[] stack = new long[n + 1];
        int[] idx = new int[n + 1];
        int p = 0;
        stack[p] = 0;
        idx[p] = -1;
        p++;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            long tmp = sum - d;
            int j = binarySearch(p, k -> stack[k] > tmp);
            if (j > 0) {
                // stack[j - 1] <= sum - d => sum - stack[k] >= d
                if (i - idx[j - 1] < ans) {
                    ans = i - idx[j - 1];
                }
            }

            while (p > 0 && stack[p - 1] >= sum) {
                p--;
            }
            stack[p] = sum;
            idx[p] = i;
            p++;
        }

        return ans;
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

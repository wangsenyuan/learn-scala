package codechef.easy.section2.replesx;

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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int x = reader.nextInt();
            int p = reader.nextInt();
            int k = reader.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            buf.append(solve(n, arr, x, p, k));
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    public static int solve(int n, int[] arr, int x, int p, int k) {
        p--;
        k--;
        Arrays.sort(arr);

        int i = search(n, ii -> arr[ii] >= x);

        int add = 0;

        if (i == n || arr[i] != x) {
            add++;
            arr[k] = x;
            Arrays.sort(arr);
        }

        if (arr[p] == x) {
            return add;
        }

        for (int d = 0; d < n; d++) {
            if (k - d >= 0 && arr[k - d] == x) {
                i = k - d;
                break;
            }
            if (k + d < n && arr[k + d] == x) {
                i = k + d;
                break;
            }
        }

        if (i <= p && p <= k) {
            return add + p - i;
        }

        if (k <= p && p <= i) {
            return add + i - p;
        }
        return -1;
    }

    private static int search(int n, Predicate<Integer> fn) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (fn.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

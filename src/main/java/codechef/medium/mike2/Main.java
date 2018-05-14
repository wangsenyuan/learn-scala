package codechef.medium.mike2;

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

    private static long[] readArray(BufferedReader input, int n) throws IOException {
        String str = input.readLine();
        StringTokenizer data = new StringTokenizer(str);
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(data.nextToken());
        }
        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        StringTokenizer data = new StringTokenizer(str);
        int n = Integer.parseInt(data.nextToken());
        long X = Long.parseLong(data.nextToken());
        long[] A = readArray(input, n);

        Arrays.sort(A);

        long[] S1 = new long[n + 1];
        long[] S2 = new long[n + 1];

        for (int i = 0; i < n; i++) {
            long x = (A[i] + 1) / 2;
            S1[i + 1] = S1[i] + x;
            S2[i + 1] = S2[i] + A[i] - x;
        }

        int notSad = binarySearch(n + 1, i -> S1[i] > X);
        notSad--;
        int sad = n - notSad;

        long Y = X - S1[notSad];
        int happy = binarySearch(n + 1, i -> S2[i] > Y);
        happy--;

        System.out.printf("%d %d\n", sad, happy);
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

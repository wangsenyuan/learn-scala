package codechef.easy.section2.redcgame;

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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = reader.nextInt();
            }
            System.out.println(solve(n, k, nums));
        }
    }

    private static long solve(int n, int k, int[] nums) {
        long sumLess = 0;
        int j = 0;


        for (int i = 0; i < n; i++) {
            if (nums[i] <= k) {
                sumLess += nums[i];
                continue;
            }
            nums[j++] = nums[i] - k;
            sumLess += k;
        }
        if (j == 0) {
            return sumLess;
        }
        if (j == 1) {
            return sumLess + nums[0];
        }

        int first = -1;
        int second = -1;
        for (int i = 0; i < j; i++) {
            if (first == -1 || nums[i] > nums[first]) {
                second = first;
                first = i;
            } else if (second == -1 || nums[i] > nums[second]) {
                second = i;
            }
        }

        long sum = 0;
        for (int i = 0; i < j; i++) {
            if (i == first || i == second) {
                continue;
            }
            sum += nums[i];
        }

        if (sum <= nums[second]) {
            return sumLess + nums[first] - (nums[second] - sum);
        }

        if ((sum & 1) == (nums[second] & 1)) {
            return sumLess + nums[first];
        }
        return sumLess + nums[first] - 1;
    }
}

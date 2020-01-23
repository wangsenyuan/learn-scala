package codechef.easy.section1.bline;

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
        long N = fastReader.nextLong();
        long[] block1 = findBlock(fastReader, N, 1, 1);
        long[] block2 = findBlock(fastReader, N, 2, 0);

        System.out.printf("2 %d %d %d %d\n", block1[0], block1[1], block2[0], block2[1]);
        System.out.flush();
    }

    private static long[] findBlock(FastReader reader, long N, int expect, int rightExpect) {
        long[] ans = new long[2];
        long left = 1;
        long right = N + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            int res = ask(reader, 1, mid);
            if (res >= expect) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans[0] = right;

        left = right;
        right = N + 1;

        while (left < right) {
            long mid = left + (right - left) / 2;
            int res = ask(reader, mid, N);
            if (res <= rightExpect) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        ans[1] = right - 1;
        return ans;
    }

    private static int ask(FastReader reader, long l, long r) {
        System.out.printf("1 %d %d\n", l, r);
        System.out.flush();
        return reader.nextInt();
    }

}

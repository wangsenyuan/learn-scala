package codechef.medium.soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int N = reader.nextInt();
        int T = reader.nextInt();

        int[][] items = new int[N][3];

        for (int i = 0; i < N; i++) {
            items[i][0] = reader.nextInt() - 1;
            items[i][1] = reader.nextInt();
            items[i][2] = reader.nextInt();
        }

        Arrays.sort(items, (a, b) -> {
            if (a[2] > b[2]) {
                return -1;
            } else if (a[2] < b[2]) {
                return 1;
            }
            return 0;
        });

        int[] cost = new int[6];
        Arrays.fill(cost, -1);
        int flag = 0;
        int total = 0;
        boolean success = false;
        for (int[] item : items) {
            int k = item[0];
            int c = item[1];
            int q = item[2];
            if (cost[k] < 0) {
                total += c;
                cost[k] = c;
            } else if (cost[k] > c) {
                total -= cost[k];
                total += c;
                cost[k] = c;
            }
            flag |= 1 << k;
            if (flag + 1 == 1 << 6 && total <= T) {
                System.out.println(q);
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println(0);
        }
    }


}

package codechef.easy.spread;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 07/02/2017.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            Bit bit = new Bit(n);
            //bit.update(0, c);
            for (int i = 0; i < m; i++) {
                String tp = scanner.next();
                if (tp.equals("Q")) {
                    int j = scanner.nextInt();
                    System.out.println(bit.query(j - 1) + c);
                } else {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    int k = scanner.nextInt();
                    bit.update(u - 1, k);
                    bit.update(v, -k);
                }
            }
        }
    }

    static class Bit {
        private int n;
        private long[] arr;

        public Bit(int n) {
            this.n = n;
            this.arr = new long[n + 1];
        }

        public void update(int i, int v) {
            i++;
            while (i <= n) {
                arr[i] += v;
                i += i & (-i);
            }
        }

        public long query(int i) {
            i++;
            long res = 0;
            while (i > 0) {
                res += arr[i];
                i -= i & (-i);
            }
            return res;
        }
    }
}

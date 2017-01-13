package codechef.easy.dishown;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 12/01/2017.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int t = scanner.nextInt();
            while (t > 0) {
                StringBuilder ans = new StringBuilder();

                int n = scanner.nextInt();

                UF uf = new UF(n);

                int[] s = new int[n];

                for (int i = 0; i < n; i++) {
                    s[i] = scanner.nextInt();
                }

                int q = scanner.nextInt();
                while (q > 0) {
                    int k = scanner.nextInt();
                    if (k == 1) {
                        int x = scanner.nextInt() - 1;
                        ans.append(uf.find(x) + 1).append("\n");
                    } else {
                        int x = scanner.nextInt() - 1;
                        int y = scanner.nextInt() - 1;
                        if (uf.sameSet(x, y)) {
                            ans.append("Invalid query!\n");
                        } else {
                            int a = uf.find(x);
                            int b = uf.find(y);
                            if (s[a] > s[b]) {
                                uf.union(a, b);
                            } else if (s[a] < s[b]) {
                                uf.union(b, a);
                            }
                        }
                    }

                    q--;
                }
                System.out.println(ans.toString());

                t--;
            }
        }
    }

    static class UF {
        private int[] elems;

        public UF(int n) {
            this.elems = new int[n];
            for (int i = 0; i < n; i++) {
                this.elems[i] = i;
            }
        }

        public int find(int a) {
            if (elems[a] != a) {
                elems[a] = find(elems[a]);
            }
            return elems[a];
        }

        public boolean sameSet(int a, int b) {
            return find(a) == find(b);
        }

        public void union(int a, int b) {
            elems[b] = a;
        }
    }
}

package codechef.easy.frogv;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 09/01/2017.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();

            Frog[] frogs = new Frog[n];
            for (int i = 0; i < n; i++) {
                int pos = scanner.nextInt();
                frogs[i] = new Frog(pos, i);
            }

            Arrays.sort(frogs, (a, b) -> {
                if (a.pos < b.pos) {
                    return -1;
                } else if (a.pos > b.pos) {
                    return 1;
                } else {
                    return 0;
                }
            });

            int[] f = new int[n];
            int[] x = new int[n];

            for (int i = 0; i < n; i++) {
                x[frogs[i].idx] = i;
                if (i > 0 && frogs[i].pos <= frogs[i - 1].pos + k) {
                    f[i] = f[i - 1];
                } else {
                    f[i] = i;
                }
            }

            for (int i = 0; i < p; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                if (f[x[a]] == f[x[b]]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    static class Frog {
        final int pos;
        final int idx;

        Frog(int pos, int idx) {
            this.pos = pos;
            this.idx = idx;
        }
    }
}

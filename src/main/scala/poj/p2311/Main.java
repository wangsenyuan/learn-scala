package poj.p2311;

import java.util.*;

/**
 * Created by senyuanwang on 15/5/31.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            if (w == h && w == 0) {
                break;
            }

            boolean win = process(w, h);

            if (win) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
        }
    }

    private static int grundy(int w, int h, int[][] mem) {
        if (mem[w][h] >= 0) {
            return mem[w][h];
        }

        BitSet set = new BitSet();
        for (int i = 2; w - i >= 2; i++) {
            set.set(grundy(i, h, mem) ^ grundy(w - i, h, mem));
        }

        for (int i = 2; h - i >= 2; i++) {
            set.set(grundy(w, i, mem) ^ grundy(w, h - i, mem));
        }

        int g = 0;
        while (set.get(g)) {
            g++;
        }
        mem[w][h] = g;
        return g;
    }

    private static boolean process(int w, int h) {
        int[][] mem = new int[w + 1][h + 1];
        for (int i = 0; i <= w; i++) {
            Arrays.fill(mem[i], -1);
        }
        return grundy(w, h, mem) != 0;
    }
}

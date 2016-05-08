package p10983;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by senyuanwang on 16/5/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int y = play(nums, l - 1, r - 1);
            System.out.println(y);
        }
    }

    private static int play(int[] nums, int l, int r) {
        BitSet bs = new BitSet();
        int sum = 0;
        for (int i = l; i <= r; i++) {
            int x = nums[i];
            if (bs.get(x)) {
                continue;
            }
            bs.set(x);
            sum += x;
        }
        return sum;
    }
}

package p20;

import java.util.Arrays;
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

        int[] fx = new int[n];
        Arrays.fill(fx, n);
        fx[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int x = nums[j];
                if (j + x >= i) {
                    fx[i] = Math.min(fx[i], fx[j] + 1);
                }
            }
        }
        System.out.println(fx[n - 1]);
    }
}

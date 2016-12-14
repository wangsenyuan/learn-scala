package codechef.march2;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 14/12/2016.
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t > 0) {
                t--;

                int n = scanner.nextInt();
                int[] leaves = new int[n];
                for (int i = 0; i < n; i++) {
                    leaves[i] = scanner.nextInt();
                }
                int stems = 1;
                for (int i = 0; i < n; i++) {
                    if (leaves[i] > stems) {
                        break;
                    }
                    stems = 2 * (stems - leaves[i]);
                    if (stems < 0) {
                        break;
                    }
                    if (stems == 0 && i < n - 1) {
                        stems = -1;
                        break;
                    }
                }

                if (stems == 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}

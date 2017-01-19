package codechef.easy.dboy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 17/01/2017.
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t > 0) {
                int n = scanner.nextInt();
                int[] h = new int[n];
                int[] k = new int[n];
                for (int i = 0; i < n; i++) {
                    h[i] = scanner.nextInt();
                }

                for (int i = 0; i < n; i++) {
                    k[i] = scanner.nextInt();
                }

                int[] dp = new int[1001];

                Arrays.fill(dp, 1000000);
                dp[0] = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = k[i]; j < 1001; j++) {
                        if (dp[j - k[i]] + 1 < dp[j]) {
                            dp[j] = dp[j - k[i]] + 1;
                        }
                    }
                }

                int res = 0;
                for (int i = 0; i < n; i++) {
                    res += dp[2 * h[i]];
                }

                System.out.println(res);
                t--;
            }
        }
    }
}

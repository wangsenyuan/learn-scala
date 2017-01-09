package codechef.easy.csub;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 14/12/2016.
 */
public class Solution {
    public static void main(String[] arg) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t > 0) {
                t--;
                scanner.nextInt();
                scanner.nextLine();
                char[] line = scanner.nextLine().toCharArray();
                long res = countSubString(line);
                System.out.println(res);
            }
        }
    }

    private static long countSubString(char[] line) {
        int n = line.length;

        int ones = 0;
        long res = 0;

        for (int i = 0; i < n; i++) {
            if (line[i] == '1') {
                res += ones;
                res += 1;
                ones += 1;
            }
        }

        return res;
    }
}

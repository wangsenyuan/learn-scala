package codechef.easy.chefgr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 26/12/2016.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = Integer.parseInt(scanner.nextLine());
            while (t > 0) {
                t -= 1;
                String[] line = scanner.nextLine().split("\\s+");
                int n = Integer.parseInt(line[0]);
                int m = Integer.parseInt(line[1]);
                String[] numStrs = scanner.nextLine().split("\\s+");
                int[] nums = Arrays.stream(numStrs).mapToInt(Integer::parseInt).toArray();
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num;
                    }
                }

                int totalDiff = 0;
                for (int num : nums) {
                    totalDiff += max - num;
                }

                if (totalDiff <= m && (m - totalDiff) % n == 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}

package codechef.easy.rowcolop;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 15/12/2016.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] firstLine = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(firstLine[0]);
            int q = Integer.parseInt(firstLine[1]);
            long[] rows = new long[n];
            long[] cols = new long[n];
            while (q > 0) {
                q--;
                String[] line = scanner.nextLine().split("\\s+");
                int x = Integer.parseInt(line[2]);
                int i = Integer.parseInt(line[1]);
                if ("RowAdd".equals(line[0])) {
                    rows[i - 1] += x;
                } else {
                    cols[i - 1] += x;
                }
            }

            long colMax = findMax(cols);
            long rowMax = findMax(rows);

            System.out.println(colMax + rowMax);
        }
    }

    private static long findMax(long[] nums) {
        long mx = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > mx) {
                mx = nums[i];
            }
        }
        return mx;
    }
}

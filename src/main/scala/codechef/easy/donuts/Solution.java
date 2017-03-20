package codechef.easy.donuts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 20/03/2017.
 */
public class Solution {

    public static void main(String[] args) {
        int[] as = new int[200001];
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            int m = Integer.parseInt(line[1]);
            String[] nums = scanner.nextLine().split("\\s+");
            for (int i = 0; i < m; i++) {
                as[i] = Integer.parseInt(nums[i]);
            }
            Arrays.sort(as, 0, m);

            long ans = 0;
            for (int i = 0, j = m - 1; i < j; ) {
                int x = as[i];
                int k = j - x; //can concat from k

                if (k <= i) {
                    ans += j - i;
                    //concat all
                    i = j;
                } else if (k == i + 1) {
                    ans += x;
                    i = j;
                } else {
                    ans += x;
                    j = k;
                    i += 1;
                }
            }
            System.out.println(ans);
        }
    }
}

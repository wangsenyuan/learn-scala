package set0000.set200.set220.p228;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/6/26.
 */
public class Solution1 {
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int a = nums[0];
        int b = a;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == b + 1) {
                b = nums[i];
                continue;
            }

            if (b > a) {
                result.add(a + "->" + b);
            } else {
                result.add("" + a);
            }
            b = a = nums[i];
        }

        if (b > a) {
            result.add(a + "->" + b);
        } else {
            result.add("" + a);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        List<String> list = summaryRanges(nums);
        for (String one : list) {
            System.out.print(one + " ");
        }
    }
}

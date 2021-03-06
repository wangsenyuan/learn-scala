package set0000.set000.set040.p046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 7/14/16.
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        return doPermute(nums, nums.length);
    }

    private List<List<Integer>> doPermute(int[] nums, int end) {
        if (end == 1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }

        int x = nums[end - 1];

        List<List<Integer>> ps = doPermute(nums, end - 1);
        List<List<Integer>> rs = new ArrayList<>();
        for (List<Integer> p : ps) {
            for (int i = 0; i < end; i++) {
                List<Integer> r = new ArrayList<>(p);
                r.add(i, x);
                rs.add(r);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ps = solution.permute(nums);
        for (List<Integer> p : ps) {
            for (int x : p) {
                System.out.printf("%d,", x);
            }
            System.out.println();
        }
    }
}

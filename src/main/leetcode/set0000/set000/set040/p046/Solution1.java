package set0000.set000.set040.p046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 7/14/16.
 */
public class Solution1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ps = Arrays.asList(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            List<List<Integer>> rs = new ArrayList<>();
            for (List<Integer> p : ps) {
                for (int j = 0; j <= i; j++) {
                    List<Integer> r = new ArrayList<>(p);
                    r.add(j, x);
                    rs.add(r);
                }
            }
            ps = rs;
        }
        return ps;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
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

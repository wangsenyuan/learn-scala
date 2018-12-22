package set000.set090.p090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 8/5/16.
 */
public class Solution1 {
    private void subsets(int[] nums, int i, int[] path, int j, int lastPick, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(toList(path, j));
            return;
        }

        if (lastPick < 0 || nums[i] != nums[lastPick]) {
            subsets(nums, i + 1, path, j, lastPick, result);
        }

        path[j] = nums[i];
        subsets(nums, i + 1, path, j + 1, i, result);
    }

    private List<Integer> toList(int[] path, int j) {
        List<Integer> rs = new ArrayList<>(j);
        for (int i = 0; i < j; i++) {
            rs.add(path[i]);
        }
        return rs;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        int[] path = new int[nums.length];
        Arrays.sort(nums);
        subsets(nums, 0, path, 0, -1, rs);
        return rs;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        List<List<Integer>> rs = solution.subsetsWithDup(new int[] {1, 2, 2});
        for (List<Integer> r : rs) {
            for (int x : r) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }
}

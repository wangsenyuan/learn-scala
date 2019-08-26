package set0000.set400.set490.p491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by senyuanwang on 2017/1/25.
 */
public class Solution1 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(nums, new ArrayList<>(), -1, res);
        return res;
    }

    private void find(int[] nums, List<Integer> list, int at, List<List<Integer>> res) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }

        Set<Integer> checked = new HashSet<>();
        for (int i = at + 1; i < nums.length; i++) {
            if (checked.contains(nums[i])) {
                continue;
            }
            if (at < 0 || nums[i] >= nums[at]) {
                checked.add(nums[i]);
                list.add(nums[i]);
                find(nums, list, i, res);
                list.remove(list.size() - 1);
            }
        }
    }
}

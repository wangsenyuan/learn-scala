package set200.set210.p217;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 15/5/25.
 */
public class Solution1 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> bs = new HashSet<>(nums.length);

        for (int x : nums) {
            if (bs.contains(x)) {
                return true;
            }
            bs.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }
}

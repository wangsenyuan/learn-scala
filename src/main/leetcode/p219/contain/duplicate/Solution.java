package p219.contain.duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 15/5/29.
 */
public class Solution {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }

        k = Math.min(nums.length, k);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }

        if(set.size() < k) {
            return true;
        }

        for (int i = k; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() == k) {
                return true;
            }
            set.remove(nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}

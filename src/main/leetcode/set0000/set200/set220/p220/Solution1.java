package set0000.set200.set220.p220;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by senyuanwang on 16/9/17.
 */
public class Solution1 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(num - t);
            if (entry != null && entry.getKey() <= num && i - entry.getValue() <= k) {
                return true;
            }
            entry = map.floorEntry(num + t);
            if (entry != null && entry.getKey() >= num && i - entry.getValue() <= k) {
                return true;
            }
            map.put(num, i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 3};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 4));
    }
}

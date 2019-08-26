package set0000.set200.set280.p287;

/**
 * Created by senyuanwang on 2016/10/7.
 */
public class Solution1 {
    public int findDuplicate(int[] nums) {
        int fast, slow;

        fast = slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        slow = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}

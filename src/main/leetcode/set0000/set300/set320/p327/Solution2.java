package set0000.set300.set320.p327;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wangsenyuan on 08/11/2016.
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {-2, 5, -1};
        int upper = 2;
        int lower = -2;
        System.out.println(solution2.countRangeSum(nums, lower, upper));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;
        TreeMap<Long, Long> tr = new TreeMap<>();
        tr.put((long) 0, (long) 1);
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = tr.subMap(from, true, to, true);
            for (Long value : sub.values()) {
                count += value;
            }
            if (tr.containsKey(sum)) {
                tr.put(sum, tr.get(sum) + 1);
            } else {
                tr.put(sum, (long) 1);
            }
        }
        return (int) count;
    }
}

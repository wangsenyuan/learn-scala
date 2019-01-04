package set100.set160.p162;

/**
 * Created by wangsenyuan on 8/27/16.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().findPeakElement(nums));
    }

    public int findPeakElement(int[] num) {
        int l = 0;
        int r = num.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;

            if (num[mid] < num[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

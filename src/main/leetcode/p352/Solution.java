package p352;

import java.util.List;

/**
 * Created by wangsenyuan on 5/31/16.
 */
public class Solution {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
        for (int i = 0; i < nums.length; i++) {
            summaryRanges.addNum(nums[i]);
            List<Interval> intervals = summaryRanges.getIntervals();
            for (Interval interval : intervals) {
                System.out.print(interval + ",");
            }
            System.out.println();
        }
    }
}

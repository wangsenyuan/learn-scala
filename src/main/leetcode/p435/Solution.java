package p435;

import common.Interval;
import common.IntervalParser;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/10/30.
 */
public class Solution implements IntervalParser {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval[] intervals = solution.parseAsIntervals("[1,2], [2,3]");
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.end - b.end);

        Interval last = null;
        int keep = 0;
        for (Interval interval : intervals) {
            if (last == null) {
                last = interval;
                keep++;
                continue;
            }

            if (last.end <= interval.start) {
                keep++;
                last = interval;
            }
        }

        return intervals.length - keep;
    }
}


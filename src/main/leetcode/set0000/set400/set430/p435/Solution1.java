package set0000.set400.set430.p435;

import common.Interval;
import common.IntervalParser;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/10/30.
 */
public class Solution1 implements IntervalParser {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Interval[] intervals = solution1.parseAsIntervals("[1,2], [2,3]");
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


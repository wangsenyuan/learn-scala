package p352;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 5/31/16.
 */
public class SummaryRanges {
    List<Interval> intervals;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        int i = 0;
        int j = intervals.size() - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            Interval interval = intervals.get(mid);
            if (val + 1 < interval.start) {
                j = mid - 1;
            } else if (val - 1 > interval.end) {
                i = mid + 1;
            } else {
                if (val >= interval.start && val <= interval.end) {
                    return;
                }
                if (val + 1 == interval.start) {
                    interval.start = val;
                    mergeIntervals(intervals, mid - 1, mid);
                    return;
                }

                if (val == interval.end + 1) {
                    mergeIntervals(intervals, mid, mid + 1);
                    return;
                }
            }
        }
        Interval interval = createInterval(val);
        intervals.add(j + 1, interval);
    }

    private void mergeIntervals(List<Interval> intervals, int i, int j) {
        if (i < 0 || j >= intervals.size()) {
            return;
        }

        Interval a = intervals.get(i);
        Interval b = intervals.get(j);
        if (a.end + 1 < b.start) {
            return;
        }
        a.end = b.end;
        intervals.remove(j);
    }

    private Interval createInterval(int val) {
        Interval interval = new Interval();
        interval.start = val;
        interval.end = val;
        return interval;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

}

package set0000.set000.set050.p057;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 7/15/16.
 */
public class Solution1 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>(intervals.size());

        boolean processed = false;
        for (Interval interval : intervals) {
            if (processed) {
                result.add(interval);
                continue;
            }

            if (interval.start > newInterval.end) {
                processed = true;
                result.add(newInterval);
                result.add(interval);
                continue;
            }

            if (interval.end < newInterval.start) {
                result.add(interval);
                continue;
            }

            if (interval.start < newInterval.start) {
                newInterval.start = interval.start;
            }

            if (interval.end > newInterval.end) {
                newInterval.end = interval.end;
            }
        }

        if (!processed) {
            result.add(newInterval);
        }


        return result;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}

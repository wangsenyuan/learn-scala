package set0000.set000.set050.p056;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangsenyuan on 7/15/16.
 */
public class Solution1 {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        Collections.sort(intervals, (Interval a, Interval b) -> {
            if (a.start() != b.start()) {
                return a.start() - b.start();
            }
            return a.end() - b.end();
        });

        Interval last = null;
        List<Interval> result = new ArrayList<>(intervals.size());
        for (Interval interval : intervals) {
            if (last == null) {
                last = interval;
                continue;
            }

            if (interval.start() > last.end()) {
                result.add(last);
                last = interval;
                continue;
            }

            if (interval.end() > last.end()) {
                last._end_$eq(interval.end());
            }
        }

        result.add(last);

        return result;
    }
}

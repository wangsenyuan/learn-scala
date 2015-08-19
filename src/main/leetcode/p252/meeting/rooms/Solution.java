package p252.meeting.rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by senyuanwang on 15/8/18.
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else if (o1.end < o2.end) {
                    return -1;
                } else if (o1.end > o2.end) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            Interval before = intervals[i - 1];
            Interval current = intervals[i];
            if (before.end > current.start) {
                return false;
            }
        }
        return true;
    }
}

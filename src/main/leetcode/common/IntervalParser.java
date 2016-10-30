package common;

/**
 * Created by senyuanwang on 2016/10/30.
 */
public interface IntervalParser {

    default Interval[] parseAsIntervals(String str) {
        String[] ss = str.split(", ");
        Interval[] intervals = new Interval[ss.length];
        int i = 0;
        for (String s : ss) {
            String x = s.substring(1, s.length() - 1);
            String[] xx = x.split(",");
            intervals[i++] = new Interval(Integer.parseInt(xx[0]), Integer.parseInt(xx[1]));
        }

        return intervals;
    }

}

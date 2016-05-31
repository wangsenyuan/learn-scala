package p352;

/**
 * Created by wangsenyuan on 5/31/16.
 */
public class Interval {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(start);
        sb.append(", ").append(end);
        sb.append(']');
        return sb.toString();
    }
}

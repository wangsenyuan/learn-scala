package set300.set340.p346;

/**
 * Created by wangsenyuan on 5/1/16.
 */
public class MovingAverage {
    private final int windowSize;
    private int sum = 0;
    private int cnt = 0;
    private int[] queue;
    private int firstAt = 0;
    private int lastAt = 0;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.windowSize = size;
        this.queue = new int[size];
    }

    public double next(int val) {
        int first = 0;
        if (cnt == windowSize) {
            cnt -= 1;
            first = queue[firstAt];
            firstAt = (firstAt + 1) % windowSize;
        }
        cnt += 1;
        lastAt = (lastAt + 1) % windowSize;
        queue[lastAt] = val;

        sum = sum - first + val;
        return 1.0 * sum / cnt;
    }
}

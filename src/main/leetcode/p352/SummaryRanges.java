package p352;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wangsenyuan on 5/31/16.
 */
public class SummaryRanges {
    /**
     * Initialize your data structure here.
     */
    private TreeMap<Integer, Integer> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        // Value existed as key
        if (tree.get(val) != null)
            return;

        // Value existed inside intervals
        Map.Entry<Integer, Integer> low = tree.lowerEntry(val);
        if (low != null && low.getValue() >= val)
            return;

        // Value can merge to end
        if (low != null && low.getValue() + 1 == val) {
            if (tree.get(val + 1) != null) {
                int start = low.getKey();
                int end = tree.get(val + 1);
                tree.remove(val + 1);
                tree.remove(low.getKey());
                tree.put(start, end);
            } else
                tree.put(low.getKey(), val);
            return;
        }

        // Value can merge to start
        Map.Entry<Integer, Integer> high = tree.higherEntry(val);
        if (high != null && high.getKey() == val + 1) {
            int end = high.getValue();
            tree.remove(high.getKey());
            tree.put(val, end);
            return;
        }

        // Isolated new value
        tree.put(val, val);
    }

    public List<Interval> getIntervals() {
        List<Interval> l = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : tree.entrySet())
            l.add(new Interval(entry.getKey(), entry.getValue()));

        return l;
    }

}

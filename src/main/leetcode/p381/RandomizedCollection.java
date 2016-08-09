package p381;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by wangsenyuan on 8/9/16.
 */
public class RandomizedCollection {
    private Map<Integer, List<Integer>> vals;

    private int[] idxs;

    private Random random;

    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.vals = new HashMap<>();
        this.idxs = createArray();
        this.random = new Random();
        random.setSeed(41);
    }

    private int[] createArray() {
        if (this.idxs == null) {
            return new int[1000];
        }
        int n = this.idxs.length;
        return Arrays.copyOf(this.idxs, n + 1000);
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        List<Integer> pos = this.vals.get(val);
        boolean has = true;
        if (pos == null) {
            has = false;
            pos = new ArrayList<>();
            this.vals.put(val, pos);
        }

        pos.add(size);
        if (size == this.idxs.length) {
            this.idxs = createArray();
        }
        this.idxs[size] = val;
        size++;
        return !has;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        List<Integer> pos = this.vals.get(val);
        if (pos == null) {
            return false;
        }
        int x = pos.remove(0);
        if (x < size - 1) {
            int last = this.idxs[size - 1];
            List<Integer> as = this.vals.get(last);
            as.remove(as.size() - 1);
            as.add(x);
            this.idxs[x] = last;
        }

        size--;

        if (pos.size() == 0) {
            this.vals.remove(val);
        }

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int selected = random.nextInt(size);
        return idxs[selected];
    }
}

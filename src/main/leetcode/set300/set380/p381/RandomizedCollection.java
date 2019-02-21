package set300.set380.p381;

import java.util.*;

/**
 * Created by wangsenyuan on 8/9/16.
 */
public class RandomizedCollection {
    private Map<Integer, Set<Integer>> vals;

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
        Set<Integer> pos = this.vals.get(val);
        boolean has = true;
        if (pos == null) {
            has = false;
            pos = new HashSet<>();
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
        Set<Integer> pos = this.vals.get(val);
        if (pos == null || pos.isEmpty()) {
            return false;
        }
        int x = pos.iterator().next();
        pos.remove(x);

        if (x < size - 1) {
            int last = this.idxs[size - 1];
            Set<Integer> as = this.vals.get(last);
            as.remove(size - 1);
            as.add(x);
            this.idxs[x] = last;
        }

        size--;

        if (pos.isEmpty()) {
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

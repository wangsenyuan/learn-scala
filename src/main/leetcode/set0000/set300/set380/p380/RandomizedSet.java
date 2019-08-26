package set0000.set300.set380.p380;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wangsenyuan on 8/4/16.
 */
public class RandomizedSet {

    private Map<Integer, Integer> vals;
    private int[] idxs;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
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
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.vals.containsKey(val)) {
            return false;
        }
        int idx = size++;
        this.vals.put(val, idx);
        if (idx >= this.idxs.length) {
            this.idxs = createArray();
        }
        this.idxs[idx] = val;

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!this.vals.containsKey(val)) {
            return false;
        }

        int idx = this.vals.remove(val);
        if (idx == size - 1) {
            size--;
        } else {
            int last = this.idxs[--size];
            this.idxs[idx] = last;
            this.vals.put(last, idx);
        }

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int selected = random.nextInt(size);
        return idxs[selected];
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.insert(2));
        System.out.println(set.insert(1));
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.remove(3));
        System.out.println(set.remove(2));
        System.out.println(set.getRandom());
    }
}

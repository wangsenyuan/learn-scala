package set100.set140.p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 8/24/16.
 */
public class LRUCache1 {
    private int capacity;
    private int actNum = 0;

    private Map<Integer, Integer> map;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void set(int key, int value) {
        Integer v = map.get(key);
        if (v != null) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (actNum == capacity) {
                map.remove(map.keySet().iterator().next());
                actNum--;
            }
            map.put(key, value);
            actNum++;
        }
    }
}

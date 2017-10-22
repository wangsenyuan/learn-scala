package p715;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> lt = map.floorEntry(left);

        if (lt != null && lt.getValue() >= left) {
            left = lt.getKey();
        }

        Map.Entry<Integer, Integer> gt = map.ceilingEntry(left);
        while (gt != null && right >= gt.getKey()) {
            right = Math.max(right, gt.getValue());
            map.remove(gt.getKey());
            gt = map.ceilingEntry(gt.getKey());
        }

        map.put(left, right);
    }


    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> lt = map.floorEntry(left);
        return lt != null && lt.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> lt = map.floorEntry(left);
        if (lt != null && lt.getValue() >= left) {
            if (lt.getKey() < left) {
                map.put(lt.getKey(), left);
            }
            if (lt.getValue() > right) {
                map.put(right, lt.getValue());
            }
        }

        Map.Entry<Integer, Integer> gt = map.ceilingEntry(left);
        while (gt != null && gt.getKey() < right) {
            map.remove(gt.getKey());
            if (right < gt.getValue()) {
                map.put(right, gt.getValue());
            }
            gt = map.ceilingEntry(left);
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(10, 14));
        System.out.println(rangeModule.queryRange(13, 15));
        System.out.println(rangeModule.queryRange(16, 17));
    }

}

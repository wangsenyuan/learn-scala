package set1000.set1400.set1490.p1495;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, TreeMap<Integer, Integer>> X = new TreeMap<>();
        Map<Integer, TreeMap<Integer, Integer>> Y = new TreeMap<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < path.length(); i++) {
            char z = path.charAt(i);
            int u = x;
            int v = y;
            if (z == 'N') {
                v++;
            } else if (z == 'E') {
                u++;
            } else if (z == 'S') {
                v--;
            } else {
                u--;
            }
            if (u != x) {
                if (!process(X, Y, x, u, y)) {
                    return true;
                }
            } else {
                // v != y
                if (!process(Y, X, y, v, x)) {
                    return true;
                }
            }
            x = u;
            y = v;
        }

        return false;
    }

    private static boolean process(Map<Integer, TreeMap<Integer, Integer>> X, Map<Integer, TreeMap<Integer, Integer>> Y,
        int x, int u, int y) {
        TreeMap<Integer, Integer> window = X.get(u);
        if (window != null) {
            Map.Entry<Integer, Integer> pos = window.floorEntry(y);
            if (pos != null && pos.getValue() >= y) {
                return false;
            }
            pos = window.ceilingEntry(y);
            if (pos != null && pos.getValue() <= y) {
                return false;
            }
        }

        if (!Y.containsKey(y)) {
            // safe
            Y.put(y, new TreeMap<>());
        } else if (Y.get(y).containsKey(u)) {
            return false;
        }

        Y.get(y).put(x, u);

        return true;
    }
}

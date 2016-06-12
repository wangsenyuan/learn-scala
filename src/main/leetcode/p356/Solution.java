package p356;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsenyuan on 6/11/16.
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }

        Collection<List<Integer>> xs = map.values();

        List<List<Integer>> list = new ArrayList<>(xs.size());
        list.addAll(xs);

        Collections.sort(list, (a, b) -> a.size() - b.size());

        List<Integer> first = list.get(0);

        try {
            float line = findParallelLine(first);

            for (int i = 1; i < list.size(); i++) {
                List<Integer> toCheck = list.get(i);
                check(toCheck, line);
            }

            return true;
        } catch (Exception ex) {
            return false;
        }


    }

    private void check(List<Integer> xs, float line) {
        Collections.sort(xs);

        for (int i = 0, j = xs.size() - 1; i <= j; i++, j--) {
            int a = xs.get(i);
            int b = xs.get(j);
            if (2 * line - a != b) {
                throw new RuntimeException();
            }
        }
    }

    private float findParallelLine(List<Integer> xs) {
        Collections.sort(xs);

        for (int i = 0, j = xs.size() - 1; i <= j; i++, j--) {
            int a = xs.get(i);
            int b = xs.get(j);
            if (i == j) {
                return a;
            }

            if (i + 1 == j) {
                return (a + b) / 2;
            }

            int a1 = xs.get(i + 1);
            int b1 = xs.get(j - 1);

            if (a1 - a != b - b1) {
                throw new RuntimeException();
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{1, 1}, {0, 0}, {-1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.isReflected(points));
    }
}

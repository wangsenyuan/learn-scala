package set400.set440.p447;

import java.util.*;

/**
 * Created by senyuanwang on 2016/11/6.
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) return 0;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            //take points[i] as current center
            int[] center = points[i];

            //key: distance from point[j] to point[i].
            //val: number of occurrence of this distance
            Map<Integer, Integer> distance = new HashMap<>();
            int c_x = center[0], c_y = center[1];
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int[] p = points[j];
                int p_x = p[0], p_y = p[1], cur_distance = (p_x - c_x) * (p_x - c_x) + (p_y - c_y) * (p_y - c_y);
                if (distance.containsKey(cur_distance)) {
                    //pair up all possible combinations
                    ans += 2 * distance.get(cur_distance);
                    //increase the occurrence of this distance
                    distance.put(cur_distance, distance.get(cur_distance) + 1);
                } else distance.put(cur_distance, 1);
            }
        }
        return ans;
    }
}

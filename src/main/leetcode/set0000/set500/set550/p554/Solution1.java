package set0000.set500.set550.p554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsenyuan on 09/04/2017.
 */
public class Solution1 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        for (List<Integer> row : wall) {
            int prev = 0;
            for (int j = 0; j < row.size(); j++) {
                prev += row.get(j);
                if (j < row.size() - 1) {
                    edges.put(prev, edges.getOrDefault(prev, 0) + 1);
                }
            }
        }

        int maxCount = 0;
        for (int count : edges.values()) {
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return wall.size() - maxCount;
    }
}

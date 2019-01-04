package set100.set160.p163;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {

    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<>();
        int from = lo - 1;
        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            if (num < from) {
                continue;
            }
            sb.setLength(0);

            if (num - from > 2) {
                sb.append(from + 1).append("->").append(num - 1);
                res.add(sb.toString());
            } else if (num - from == 2) {
                sb.append(from + 1);
                res.add(sb.toString());
            }

            from = num;
        }

        sb.setLength(0);
        if (hi - from >= 2) {
            sb.append(from + 1).append("->").append(hi);
            res.add(sb.toString());
        } else if (hi - from == 1) {
            sb.append(from + 1);
            res.add(sb.toString());
        }

        return res;
    }

}

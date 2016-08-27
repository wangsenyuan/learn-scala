package p163;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {

    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<>();
        int from = lo - 1;
        for (int num : a) {
            if (num < from) {
                continue;
            }

            if (num - from > 2) {
                res.add(String.format("%d->%d", from + 1, num - 1));
            } else if (num - from == 2) {
                res.add(String.format("%d", from + 1));
            }

            from = num;
        }

        if (hi - from >= 2) {
            res.add(String.format("%d->%d", from + 1, hi));
        } else if (hi - from == 1) {
            res.add(String.format("%d", from + 1));
        }

        return res;
    }

}

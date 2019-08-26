package set0000.set300.set360.p364;

import set0000.set300.set330.p339.NestedInteger;

import java.util.List;

/**
 * Created by wangsenyuan on 01/12/2016.
 */
public class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = maxDepth(nestedList);
        return sum(nestedList, depth);
    }

    private int sum(List<NestedInteger> list, int depth) {
        if (list.isEmpty()) {
            return 0;
        }

        int res = 0;
        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                res += nestedInteger.getInteger() * depth;
            } else {
                res += sum(nestedInteger.getList(), depth - 1);
            }
        }
        return res;
    }


    private int maxDepth(List<NestedInteger> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int res = 0;

        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                res = Math.max(res, 1);
            } else {
                res = Math.max(maxDepth(nestedInteger.getList()) + 1, res);
            }
        }

        return res;
    }
}

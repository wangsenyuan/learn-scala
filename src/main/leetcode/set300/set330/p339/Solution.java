package set300.set330.p339;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 3/31/16.
 */
public class Solution {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1, 0);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth, int sum) {
        if (nestedList.size() == 0) {
            return sum;
        }

        List<NestedInteger> nextLevel = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                nextLevel.addAll(nestedInteger.getList());
            }
        }
        return depthSum(nextLevel, depth + 1, sum);
    }
}

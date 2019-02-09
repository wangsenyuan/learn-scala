package set300.set330.p335;

/**
 * Created by wangsenyuan on 10/11/2016.
 */
public class Solution1 {

    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
            if (i >= 4 && x[i - 1] == x[i - 3] && x[i - 2] <= x[i] + x[i - 4]) {
                return true;
            }

            if (i >= 5 && x[i - 2] > x[i - 4] && x[i - 3] >= x[i - 1] && x[i] + x[i - 4] >= x[i - 2]
                && x[i - 5] + x[i - 1] >= x[i - 3]) {
                return true;
            }
        }

        return false;
    }
}

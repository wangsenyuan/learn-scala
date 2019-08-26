package set0000.set300.set330.p335;

/**
 * Created by senyuanwang on 16/2/28.
 */
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        boolean flag = true;
        for (int i = 2; i < x.length - 1; i++) {
            if (x[i] == x[i - 2]) {
                if (x[i + 1] >= x[i - 1]) {
                    return true;
                } else if (flag && i > 2 && x[i + 1] + x[i - 3] >= x[i - 1]) {
                    return true;
                }
                flag = false;
            } else if (x[i] < x[i - 2]) {
                if (x[i + 1] >= x[i - 1]) {
                    return true;
                } else if (flag && i > 3 && x[i] + x[i - 4] >= x[i - 2]) {
                    if (x[i + 1] + x[i - 3] >= x[i - 1]) {
                        return true;
                    }
                }
                flag = false;
            } else {
                flag = true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(solution.isSelfCrossing(nums));
    }
}

package p134;

/**
 * Created by wangsenyuan on 8/19/16.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ) {
            int j = i;
            int left = gas[i];
            for (int k = 0; k < n; k++) {
                left -= cost[j];
                j = (j + 1) % n;
                if (left < 0 || j == i) {
                    break;
                }
                left += gas[j];
            }

            if (left >= 0) {
                return i;
            }
            if (j <= i) {
                return -1;
            }
            i = j;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {6, 0, 1, 3, 2};
        int[] cost = {4, 5, 2, 5, 5};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}

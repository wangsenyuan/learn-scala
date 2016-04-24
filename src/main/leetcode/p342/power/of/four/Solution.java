package p342.power.of.four;

/**
 * Created by wangsenyuan on 4/19/16.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        for (int i = 0; i < 32; i += 2) {
            int x = 1 << i;
            if ((num & x) > 0) {
                int y = ~x;

                if ((num & y) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int num = 1; num < Integer.MAX_VALUE && num > 0; num *= 4) {
            System.out.println(String.format("%d is power of four? %b", num, solution.isPowerOfFour(num)));
        }
    }
}

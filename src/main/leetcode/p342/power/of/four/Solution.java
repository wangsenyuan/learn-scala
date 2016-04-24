package p342.power.of.four;

/**
 * Created by senyuanwang on 16/4/18.
 */
public class Solution {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        int rightOneBit = -1;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                rightOneBit = i;
                break;
            }
            num = num >> 1;
        }
        for (int i = 0; i < 32; i += 2) {
            if (rightOneBit == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(5));
    }
}

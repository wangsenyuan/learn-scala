package p343.split.intnum;

/**
 * Created by wangsenyuan on 4/19/16.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        if (n == 4)
            return n;
        if ((n - 1) % 3 == 0) {
            int result = integerBreak(n - 1) / 3 * 4;
            return result;
        }
        int result = integerBreak(n - 1) / 2 * 3;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(3));
    }
}

package set0000.set200.set270.p276;

/**
 * Created by senyuanwang on 15/9/5.
 * <p>
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that <b>no more than two</b> adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int a = k;
        int b = k * (k - 1);

        for (int i = 2; i < n; i++) {
            int c = b;
            b = (a + b) * (k - 1);
            a = c;
        }

        return a + b;
    }
}

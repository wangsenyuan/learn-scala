package p052;

/**
 * Created by wangsenyuan on 7/15/16.
 */
public class Solution {
    int sum = 0;
    int upperlim = 1;

    public int totalNQueens(int n) {
        upperlim = (upperlim << n) - 1;
        helper(0, 0, 0);
        return sum;
    }

    void helper(int row, int ld, int rd) {
        if (row != upperlim) {
            int pos = upperlim & ~(row | ld | rd);
            while (pos > 0) {
                int p = pos & -pos;

                pos -= p;

                helper(row + p, (ld + p) << 1, (rd + p) >> 1);
            }
        } else {
            sum++;
        }
    }
}

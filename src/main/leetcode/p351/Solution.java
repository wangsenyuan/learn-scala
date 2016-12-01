package p351;

import java.util.HashSet;

/**
 * Created by wangsenyuan on 5/23/16.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPatterns(1, 2));
    }

    public int numberOfPatterns(int m, int n) {
        if (m > n || n <= 0)
            return 0;
        if (n == 1)
            return 9;
        int res = 0;
        boolean[] used = new boolean[9];
        for (int l = m; l <= n; l++) {
            used[0] = true;
            int a = count(0, l - 1, used);
            used[0] = false;
            res += a * 4;
            used[1] = true;
            int b = count(1, l - 1, used);
            used[1] = false;
            res += b * 4;
            used[4] = true;
            int c = count(4, l - 1, used);
            used[4] = false;
            res += c;
        }
        return res;
    }

    private int count(int last, int len, boolean[] used) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last, used)) {
                used[i] = true;
                sum += count(i, len - 1, used);
                used[i] = false;
            }
        }
        return sum;
    }


    private boolean isValid(int index, int last, boolean[] used) {
        if (used[index])
            return false;
        // first digit of the pattern
        if (last == -1)
            return true;
        // knight moves or adjacent cells (in a row or in a column)
        if ((index + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (index + last) / 2;
        if (mid == 4)
            return used[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }
}

package set0000.set300.set370.p376;

/**
 * Created by wangsenyuan on 7/21/16.
 */
public class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int n = nums.length;
        int[] as = new int[n];
        int pa = 0;

        for (int i = 0; i < nums.length; i++) {
            pa = appendIfWiggle(as, pa, nums[i]);
        }

        return pa;

    }

    private int appendIfWiggle(int[] xs, int size, int x) {
        if (size == 0 || (size == 1 && xs[0] != x)) {
            xs[size++] = x;
            return size;
        }

        if (size == 1 && xs[0] == x) {
            return size;
        }


        int a = xs[size - 2];
        int b = xs[size - 1];

        if ((a > b && b < x) || (a < b && b > x)) {
            xs[size++] = x;
            return size;
        }

        if ((a > b && b > x) || (a < b && b < x)) {
            xs[size - 1] = x;
            return size;
        }

        return size;
    }
}

package set200.set260.p263;

import java.util.BitSet;

/**
 * Created by senyuanwang on 15/8/19.
 */
public class Solution1 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        }

        if (num % 3 == 0) {
            return isUgly(num / 3);
        }

        if (num % 5 == 0) {
            return isUgly(num / 5);
        }

        return false;
    }

    public int nthUglyNumber1(int n) {
        if (n <= 5) {
            return n;
        }
        int[] zs = {2, 3, 5};
        BitSet bs = new BitSet();
        bs.set(1);
        bs.set(2);
        bs.set(3);
        bs.set(4);
        bs.set(5);

        int i = 6;
        int x = 5;
        while (i <= n) {
            int nextMin = Integer.MAX_VALUE;
            for (int z : zs) {
                int y = x / z;
                while (y * z <= x) {
                    y = bs.nextSetBit(y + 1);
                }
                nextMin = Math.min(nextMin, y * z);
            }
            x = nextMin;
            bs.set(x);
            i += 1;
        }
        return x;
    }

    public int nthUglyNumber(int n) {
        if (n <= 5) {
            return n;
        }
        int[] zs = {2, 3, 5};
        int[] nums = new int[n + 1];
        int i = 1;
        for (; i <= 5; i++) {
            nums[i] = i;
        }
        int x = 5;

        while (i <= n) {
            int nextMin = Integer.MAX_VALUE;
            for (int z : zs) {
                int y = x / z;
                int j = nextPosGe(nums, y, 1, i);
                while (nums[j] * z <= x) {
                    j = j + 1;
                }
                nextMin = Math.min(nextMin, nums[j] * z);
            }
            x = nextMin;
            nums[i] = x;
            i += 1;
        }

        return nums[n];
    }

    private int nextPosGe(int[] nums, int y, int start, int end) {
        int i = start, j = end - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < y) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    public int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.nthUglyNumber2(20));
        for (int i = 1; i <= 20; i++) {
            System.out.println(solution.nthUglyNumber2(i));
        }

    }
}

package set0000.set200.set220.p220;

import java.util.Arrays;

/**
 * Created by senyuanwang on 15/6/1.
 */
public class Solution2 {

    public static long diffAbs(long a, long b) {
        if (a > b) return a - b;
        else return b - a;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        NumWithIndex[] nis = new NumWithIndex[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nis[i] = new NumWithIndex(nums[i], i);
        }

        Arrays.sort(nis);

        for (int i = 0; i < nis.length; i++) {
            int j = i + 1;
            while (j < nis.length && diffAbs(nis[j].num, nis[i].num) <= t) {
                if (Math.abs(nis[j].index - nis[i].index) <= k) {
                    return true;
                }
                j += 1;
            }
        }
        return false;
    }

    static class NumWithIndex implements Comparable<NumWithIndex> {
        final int num, index;

        NumWithIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(NumWithIndex that) {
            return this.num - that.num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}

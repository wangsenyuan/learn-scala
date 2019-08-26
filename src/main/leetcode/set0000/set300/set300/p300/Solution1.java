package set0000.set300.set300.p300;

/**
 * Created by senyuanwang on 15/11/3.
 */
public class Solution1 {

    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] len = new int[nums.length];

        len[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int mx = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    mx = Math.max(mx, len[j] + 1);
                }
            }
            len[i] = mx;
        }

        int mx = len[0];
        for (int i = 1; i < len.length; i++) {
            mx = Math.max(mx, len[i]);
        }

        return mx;
    }

    private int ceilIndex(int[] nums, int l, int r, int key) {
        int m;

        while (r - l > 1) {
            m = l + (r - l) / 2;
            //(nums[m] >= key ? r : l) = m; // ternary expression returns an l-value
            if (nums[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] tailTable = new int[n];

        tailTable[0] = nums[0];

        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < tailTable[0]) {
                tailTable[0] = nums[i];
            } else if (nums[i] > tailTable[len - 1]) {
                tailTable[len++] = nums[i];
            } else {
                tailTable[ceilIndex(tailTable, -1, len - 1, nums[i])] = nums[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums = {2, 5, 3, 7, 11, 8, 10, 13, 6};

        System.out.println(solution1.lengthOfLIS(nums));
    }

}

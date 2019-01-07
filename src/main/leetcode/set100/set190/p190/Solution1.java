package set100.set190.p190;

/**
 * Created by senyuanwang on 15/2/26.
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int toSwap = k;
        int swapped = 0;
        int j = -1;
        for (int i = n - 1; i >= 0; i -= swapped) {
            j = i;
            while (j - toSwap >= 0 && i - j < toSwap) {
                swap(nums, j - toSwap, j);
                j--;
            }
            swapped = i - j;
            if (swapped == 0) {
                return;
            }
            if (swapped != toSwap) {
                toSwap -= swapped;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

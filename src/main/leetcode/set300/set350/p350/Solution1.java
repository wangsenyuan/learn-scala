package set300.set350.p350;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 5/21/16.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        int[] nums3 = solution1.intersect(nums1, nums2);
        System.out.println(nums3);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        int[] nums3 = new int[Math.min(nums1.length, nums2.length)];
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++) {
            int x = nums1[i];
            while (j < nums2.length && nums2[j] < x) {
                j++;
            }
            if (j == nums2.length) {
                break;
            }
            if (nums2[j] > x) {
                continue;
            }

            nums3[k++] = x;
            j++;
        }

        return Arrays.copyOf(nums3, k);
    }

}

package p033;

import java.util.Arrays;

/**
 * Created by senyuanwang on 16/7/10.
 */
public class Solution {

    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int p = -1;
        while (i < j && nums[i] > nums[j]) {
            int m = (i + j) / 2;
            if (i == m) {
                p = i;
                break;
            }
            if (nums[i] < nums[m]) {
                i = m;
                p = i;
            } else {
                j = m;
            }
        }
        int index = -1;
        if (p < 0) {
            index = Arrays.binarySearch(nums, target);
        } else if (nums[0] <= target) {
            index = Arrays.binarySearch(nums, 0, p + 1, target);
        } else {
            index = Arrays.binarySearch(nums, p + 1, nums.length, target);
        }

        if (index < 0) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 3));
        System.out.println(search(nums, 4));
        System.out.println(search(nums, 2));

        nums = new int[]{5, 1, 3};
        System.out.println(search(nums, 5));


    }
}

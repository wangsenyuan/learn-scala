package set0000.set200.set210.p215;

/**
 * Created by senyuanwang on 15/5/23.
 */
public class Solution1 {

    public static int qsort(int[] nums, int left, int right, int k) {
        if (left + 3 <= right) {
            int pivot = median3(nums, left, right);
            //            int pivot = nums[right];
            int i = left, j = right - 1;

            while (i < j) {
                while (nums[++i] > pivot) {
                }
                while (nums[--j] < pivot) {
                }

                if (i < j) {
                    swap(nums, i, j);
                }
            }
            swap(nums, i, right - 1);
            if (k == i) {
                return nums[i];
            } else if (k > i) {
                return qsort(nums, i + 1, right, k);
            } else {
                return qsort(nums, left, i - 1, k);
            }
        } else {
            insertSort(nums, left, right);
            return nums[k];
        }
    }

    private static int median3(int[] nums, int left, int right) {
        int center = (left + right) / 2;
        if (nums[left] < nums[center]) {
            swap(nums, left, center);
        }

        if (nums[left] < nums[right]) {
            swap(nums, left, right);
        }

        if (nums[center] < nums[right]) {
            swap(nums, center, right);
        }

        swap(nums, center, right - 1);
        return nums[right - 1];
    }

    private static void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] < tmp) {
                nums[j] = nums[j - 1];
                j -= 1;
            }
            nums[j] = tmp;
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        return qsort(nums, 0, nums.length - 1, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        //        int[] nums = {3, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(findKthLargest(nums, 8));
    }
}

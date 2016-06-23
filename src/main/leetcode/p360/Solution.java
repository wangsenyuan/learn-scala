package p360;

/**
 * Created by wangsenyuan on 6/17/16.
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0;
        int j = nums.length - 1;
        double x = -1.0 * b / 2 / a;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        boolean firstHalfAsc = a < 0;

        int[] first = transform(nums, 0, i, a, b, c, firstHalfAsc);
        int[] second = transform(nums, i, nums.length, a, b, c, !firstHalfAsc);

        return merge(first, second);
    }

    private int[] merge(int[] as, int[] bs) {
        int[] cs = new int[as.length + bs.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < as.length && j < bs.length) {
            int a = as[i];
            int b = bs[j];
            if (a <= b) {
                cs[k++] = a;
                i++;
            } else {
                cs[k++] = b;
                j++;
            }
        }
        while (i < as.length) {
            cs[k++] = as[i++];
        }

        while (j < bs.length) {
            cs[k++] = bs[j++];
        }

        return cs;
    }



    private int[] transform(int[] nums, int start, int end, int a, int b, int c, boolean asc) {
        int[] result = new int[end - start];

        for (int i = 0; i < end - start; i++) {
            int j = start + i;
            if (!asc) {
                j = end - 1 - i;
            }
            result[i] = nums[j] * nums[j] * a + nums[j] * b + c;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -2, 2, 4};
        int a = 0, b = 3, c = 5;
        int[] result = solution.sortTransformedArray(nums, a, b, c);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

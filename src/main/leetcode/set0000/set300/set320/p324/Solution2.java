package set0000.set300.set320.p324;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by wangsenyuan on 05/11/2016.
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        IntStream.of(nums).forEach(System.out::println);
    }

    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        Random random = new Random(41);
        // find median
        int i = 0, j = n - 1;
        int median = 0;
        while (i <= j) {
            int p = i, a = i + 1, b = j;
            int c = random.nextInt(j - i + 1) + i;
            swap(nums, p, c);
            while (a <= b) {
                if (nums[a] >= nums[p])
                    swap(nums, a, b--);
                else
                    a++;
            }
            swap(nums, p, b);
            if (b == n / 2) {
                median = nums[b];
                break;
            } else if (b < n / 2)
                i = b + 1;
            else
                j = b - 1;
        }

        int first = 0;
        int mid = 0;
        int last = n - 1;

        while (mid <= last) {
            if (nums[m(mid, n)] > median) {
                swap(nums, m(mid++, n), m(first++, n));
            } else if (nums[m(mid, n)] < median) {
                swap(nums, m(mid, n), m(last--, n));
            } else {
                mid++;
            }
        }


    }

    private static int m(int idx, int n) {
        return (2 * idx + 1) % (n | 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

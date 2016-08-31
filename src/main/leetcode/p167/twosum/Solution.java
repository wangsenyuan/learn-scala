package p167.twosum;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class Solution {

    /**
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            int left = target - numbers[i];

            for (int k = i + 1; k <= j; ) {
                int mid = (k + j) / 2;
                if (numbers[mid] == left) {
                    return new int[] {i + 1, mid + 1};
                }
                if (numbers[mid] > left) {
                    j = mid - 1;
                } else {
                    k = mid + 1;
                }
            }
        }
        throw new RuntimeException("");
    }

    public int[] twoSum1(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            }

            if (sum > target) {
                j--;
            } else {
                i++;
            }

        }
        throw new RuntimeException("");
    }
}

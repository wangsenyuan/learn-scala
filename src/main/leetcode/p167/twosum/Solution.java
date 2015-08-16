package p167.twosum;

import java.util.Arrays;

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
        int[] result = new int[2];

        for(int i = 1; i <= numbers.length; i++) {
            int x = numbers[i - 1];
            int y = target - x;
            int j = Arrays.binarySearch(numbers, i, numbers.length, y);
            if(j >= i) {
                result[0] = i;
                result[1] = j + 1;
                break;
            }
        }

        return result;
    }
}

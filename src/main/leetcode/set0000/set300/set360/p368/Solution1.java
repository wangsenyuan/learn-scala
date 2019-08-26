package set0000.set300.set360.p368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by senyuanwang on 2016/12/3.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 72};
        List<Integer> result = solution1.largestDivisibleSubset(nums);
        result.forEach(System.out::println);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<Integer>[] numberOfFactors = new List[nums.length];

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) {
                    continue;
                }
                List<Integer> factors = numberOfFactors[j];
                if (factors.size() > list.size()) {
                    list = factors;
                }
            }
            List<Integer> copy = new ArrayList<>(list);
            copy.add(nums[i]);
            numberOfFactors[i] = copy;
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (numberOfFactors[j].size() > result.size()) {
                result = numberOfFactors[j];
            }
        }


        return result;
    }

}

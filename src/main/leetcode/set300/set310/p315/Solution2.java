package set300.set310.p315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangsenyuan on 28/10/2016.
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums =
            {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2,
                97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        //int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        List<Integer> idx = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                idx.add(i);
                res.add(0);
                continue;
            }
            int x = nums[i];

            int a = 0;
            int b = res.size() - 1;
            while (a <= b) {
                int c = a + (b - a) / 2;
                int j = idx.get(c);
                if (nums[j] >= x) {
                    b = c - 1;
                } else {
                    a = c + 1;
                }
            }
            res.add(b + 1);
            idx.add(b + 1, i);
        }
        Collections.reverse(res);
        return res;
    }
}

package set0000.set200.set220.p229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by senyuanwang on 15/6/29.
 */
public class Solution1 {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        int a = nums[0], acnt = 1;
        int b = nums[0], bcnt = 1;

        //        Arrays.fill(ys, -1);

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            if (x == a) {
                acnt += 1;
            } else if (x == b) {
                bcnt += 1;
            } else if (acnt == 0) {
                a = x;
                acnt++;
            } else if (bcnt == 0) {
                b = x;
                bcnt++;
            } else {
                acnt--;
                bcnt--;
            }
        }

        acnt = bcnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                acnt += 1;
            } else if (nums[i] == b) {
                bcnt += 1;
            }
        }
        List<Integer> result = new ArrayList<>(3);

        if (acnt > nums.length / 3) {
            result.add(a);
        }

        if (bcnt > nums.length / 3) {
            result.add(b);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 6, 6, 7, 7};

        List<Integer> result = majorityElement(nums);

        for (Integer x : result) {
            System.out.print(x + " ");
        }
    }
}

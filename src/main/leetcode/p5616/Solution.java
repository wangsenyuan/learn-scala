package p5616;

import java.util.TreeSet;

public class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> even = new TreeSet<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                even.add(2 * num);
            }
        }
        int res = 1 << 30;
        while (even.size() > 0) {
            int x = even.pollLast();
            if (x % 2 == 1) {
                break;
            }
            even.add(x / 2);
            res = Math.min(res, even.last() - even.first());
        }

        return res;
    }
}

package p5616;

import java.util.TreeSet;

public class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                even.add(2 * num);
            }
        }
        int res = 1 << 30;
        while (even.size() > 0) {
            int x = even.last();
            int z = x;
            if (!odd.isEmpty()) {
                z = Math.max(odd.last(), z);
            }
            int y = even.first();
            if (!odd.isEmpty()) {
                y = Math.min(odd.first(), y);
            }
            res = Math.min(res, z - y);

            x = even.pollLast();
            x /= 2;
            if (x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }

        return res;
    }
}

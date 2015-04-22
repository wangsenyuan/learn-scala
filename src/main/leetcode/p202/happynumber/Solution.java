package p202.happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 15/4/22.
 */
public class Solution {

    public static boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private static boolean isHappy(int n, Set<Integer> checked) {
        if (checked.contains(n)) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        checked.add(n);

        int sum = 0;

        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n = n / 10;
        }

        return isHappy(sum, checked);
    }

    public static void main(String[] args) {
        System.out.println("19 is happy? " + isHappy(19));
    }
}

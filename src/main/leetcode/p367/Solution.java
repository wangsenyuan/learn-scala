package p367;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 16/6/26.
 */
public class Solution {

    public static boolean isPerfectSquare(int num) {
        int guess = num;
        Set<Integer> seen = new HashSet<>();
        seen.add(guess);
        while (guess * guess != num) {
            guess = (guess + num / guess) / 2;
            if (guess <= 0 || seen.contains(guess)) {
                return false;
            }
            seen.add(guess);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(15));
    }
}

package p069;

/**
 * Created by wangsenyuan on 7/5/16.
 */
public class Solution {
    public static int mySqrt(int x) {
        double guess = x;

        for (int i = 0; i < 10; i++) {
            guess = (guess + x / guess) / 2;
        }

        return (int) guess;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}

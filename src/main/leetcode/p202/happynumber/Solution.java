package p202.happynumber;

import scalaz.Alpha;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by senyuanwang on 15/4/22.
 */
public class Solution {

    public static boolean isHappy(int n) {
        while (n != 89) {
            if (n == 1) {
                return true;
            }

            int m = 0;
            while (n > 0) {
                m += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = m;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("19 is happy? " + isHappy(19));
    }
}

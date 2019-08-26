package set0000.set100.set190.p191;

/**
 * Created by senyuanwang on 15/3/12.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }
}

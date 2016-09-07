package p191;

/**
 * Created by senyuanwang on 15/3/12.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int len = 32;
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (((n >> i) & 1) == 1) {
                num += 1;
            }
        }

        return num;
    }
}

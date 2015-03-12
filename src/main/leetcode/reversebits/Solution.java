package reversebits;

/**
 * Created by senyuanwang on 15/3/8.
 */
public class Solution {

    public static void main(String[] args) {
        int x = 1;
        int y = reverseBits(x);
        System.out.println(y);
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int total = 32;
        for (int i = 0; i < total / 2; i++) {
            n = swapBits(n, i, total - i - 1);
        }
        return n;
    }

    private static int swapBits(int n, int i, int j) {
        int lo = (n >> i) & 1;
        int hi = (n >> j) & 1;
        if ((lo ^ hi) == 1) { //both bits are different so need to swap
            n ^= ((1 << i) | (1 << j));
        }
        return n;
    }
}

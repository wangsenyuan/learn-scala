package set0000.set200.set230.p231;

/**
 * Created by senyuanwang on 15/7/7.
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }

        while(n > 1) {
            if((n & 1) == 1) {
                return false;
            }

            n >>= 1;
        }

        return true;
    }
}

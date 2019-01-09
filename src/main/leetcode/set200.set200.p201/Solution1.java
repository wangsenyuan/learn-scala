package set200.set200.p201;

/**
 * Created by senyuanwang on 15/4/16.
 */
public class Solution1 {

    public static int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt += 1;
        }
        return n << cnt;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}

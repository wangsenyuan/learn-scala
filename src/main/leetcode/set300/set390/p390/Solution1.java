package set300.set390.p390;

/**
 * Created by senyuanwang on 16/8/28.
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(8));
        System.out.println(lastRemaining(10));

    }

    public static int lastRemaining(int n) {
        int start = 1;
        int step = 1;
        int cnt = n;

        while (cnt > 1) {
            if ((cnt & 1) == 1) {
                start += (cnt - 2) * step;
            } else {
                start += (cnt - 1) * step;
            }
            cnt >>= 1;
            step *= -2;
        }

        return start;
    }

}

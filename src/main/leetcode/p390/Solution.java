package p390;

/**
 * Created by senyuanwang on 16/8/28.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(8));
        System.out.println(lastRemaining(10));

    }

    public static int lastRemaining(int n) {
        return find(1, 1, n);
    }

    private static int find(int start, int step, int cnt) {
        if (cnt == 1) {
            return start;
        }
        if (cnt % 2 == 1) {
            return find(start + (cnt - 2) * step, -2 * step, (cnt - 1) / 2);
        } else {
            return find(start + (cnt - 1) * step, -2 * step, cnt / 2);
        }
    }
}

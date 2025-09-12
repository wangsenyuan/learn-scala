package fun;

import java.util.Arrays;

public class P1 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] sample = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(play(sample));
    }

    public static long play(int[] steaks) {
        Arrays.sort(steaks);
        long res = 0;
        int day = 0;
        int l = 0;
        int r = steaks.length - 1;
        while (r - l + 1 >= 4) {
            if (day == 0) {
                res += steaks[r];
                r--;
                l += 3;
            } else {
                res += steaks[l + 2];
                l += 4;
            }
            day ^= 1;
        }
        return res;
    }
}

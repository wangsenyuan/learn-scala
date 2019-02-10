package set300.set330.p338;

/**
 * Created by senyuanwang on 16/3/20.
 */
public class Solution1 {
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        if (num == 0) {
            return res;
        }

        int base = 1, count = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = 1 + res[i % base];
            if (++count == base) {
                base *= 2;
                count = 0;
            }
        }
        return res;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}

package set0000.set400.set450.p458;

/**
 * Created by wangsenyuan on 08/11/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.poorPigs(1000, 15, 60));
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets-- == 1) {
            return 0;
        }
        if (minutesToDie > minutesToTest) {
            return -1;
        }
        int base = minutesToTest / minutesToDie + 1;
        int count = 0;
        while (buckets > 0) {
            buckets /= base;
            count++;
        }
        return count;
    }
}

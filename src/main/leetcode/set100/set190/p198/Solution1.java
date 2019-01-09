package set100.set190.p198;

/**
 * Created by senyuanwang on 15/4/6.
 */
public class Solution1 {

    public static int rob(int[] num) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < num.length; i++) {
            int c = a;
            if (b > a) {
                c = b;
            }
            b = a + num[i];
            a = c;
        }
        if (a >= b) {
            return a;
        }
        return b;
    }


    public static void main(String[] args) {
        int[] num = new int[] {1, 1, 1};

        System.out.println(rob(num));
    }
}


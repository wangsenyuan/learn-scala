package houserobber;

/**
 * Created by senyuanwang on 15/4/6.
 */
public class Solution {

    public static int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        if (num.length == 1) {
            return num[0];
        }

        if (num.length == 2) {
            return max(num[0], num[1]);
        }

        int a = num[0];
        int b = max(num[0], num[1]);

        for (int i = 2; i < num.length; i++) {
            int c = a + num[i];
            a = b;
            b = max(b, c);
        }

        return b;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 1};

        System.out.println(rob(num));
    }
}


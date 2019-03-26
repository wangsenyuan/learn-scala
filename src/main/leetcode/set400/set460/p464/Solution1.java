package set400.set460.p464;

import java.util.*;

/**
 * Created by senyuanwang on 2016/11/20.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.canIWin(10, 11)); //false
        System.out.println(solution1.canIWin(4, 6)); //true
        System.out.println(solution1.canIWin(18, 79));
        System.out.println(solution1.canIWin(5, 50)); //false
        System.out.println(solution1.canIWin(10, 40)); //false
        System.out.println(solution1.canIWin(10, 0)); //true
        System.out.println(solution1.canIWin(18, 188)); //false

    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (desiredTotal > sum) {
            return false;
        }
        return play(0, 0, new HashMap<>(), desiredTotal, maxChoosableInteger, 0) == 0;
    }

    private int play(int used, int sum, HashMap<Integer, Integer> dp, int desire, int max, int player) {
        if (dp.containsKey(used)) {
            return dp.get(used);
        }
        int win = 1 - player;
        for (int i = 1; i <= max && win != player; i++) {
            if ((used & (1 << i)) > 0) {
                continue;
            }

            if (sum + i >= desire) {
                win = player;
            } else {
                win = play(used | (1 << i), sum + i, dp, desire, max, 1 - player);
            }
        }
        dp.put(used, win);
        return win;
    }
}

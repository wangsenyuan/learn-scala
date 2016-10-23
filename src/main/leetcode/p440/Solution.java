package p440;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 2016/10/23.
 */
public class Solution {

    public static void main(String[] args) {
   /*     for (int i = 1; i < 13; i++) {
            System.out.println(findKthNumber(13, i));
        }*/
        System.out.println(findKthNumber(681692778, 351251360));
    }

    public static int findKthNumber(int n, int k) {
        long current = 1;
        for (int i = 1; i < k; i++) {
            if (current * 10 <= n) {
                current *= 10;
            } else if (current < n && current % 10 < 9) {
                current++;
            } else {
                while ((current / 10) % 10 == 9) {
                    current /= 10;
                }
                current = current / 10 + 1;
            }
        }

        return (int) current;
    }
}

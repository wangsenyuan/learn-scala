package set0000.set300.set370.p370;

/**
 * Created by wangsenyuan on 6/29/16.
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int d = update[2];
            array[i] += d;
            if (j < length - 1) {
                array[j + 1] -= d;
            }
        }

        for (int i = 1; i < length; i++) {
            array[i] += array[i - 1];
        }

        return array;
    }
}

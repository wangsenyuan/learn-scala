package set0000.set400.set460.p465;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by senyuanwang on 2016/11/20.
 */
public class Solution {

    public int minTransfers(int[][] trans) {
        Map<Integer, Integer> net = new HashMap<>();
        for (int i = 0; i < trans.length; i++) {
            net.put(trans[i][0], net.getOrDefault(trans[i][0], 0) - trans[i][2]);
            net.put(trans[i][1], net.getOrDefault(trans[i][1], 0) + trans[i][2]);
        }
        int[] temp = new int[net.size()];
        int i = 0;
        for (int j : net.values()) {
            if (j != 0) temp[i++] = j;
        }
        int[] a = new int[i];
        System.arraycopy(temp, 0, a, 0, i);
        transactions.clear();
        number = Integer.MAX_VALUE;
        mintran(a, 0);
        return number;
    }

    private List<int[]> transactions = new ArrayList<>();
    private int number = Integer.MAX_VALUE;

    private void mintran(int[] a, int start) {
        //System.out.println(Arrays.toString(a));
        if (transactions.size() >= number) return;
        if (number == (a.length + 1) / 2) return;

        if (a.length < 2) {
            number = 0;
            return;
        } else if (a.length == 2) {
            number = a[0] == 0 ? 0 : 1;
            return;
        } else {
            int ind = -1;
            int max = Integer.MIN_VALUE;
            int i = start;
            for (; i < a.length; i++) {
                if (Math.abs(a[i]) > max) {
                    max = Math.abs(a[i]);
                    ind = i;
                }
            }

            if (max == 0 || start == a.length) {
                if (transactions.size() < number) {
                    number = transactions.size();
                }
                return;
            }

            int temp = a[ind];
            a[ind] = a[start];
            a[start] = temp;

            for (i = start + 1; i < a.length; i++) {
                if (a[i] * a[start] < 0) {
                    transactions.add(new int[]{a[i], a[start]});
                    temp = a[i];
                    a[i] += a[start];
                    mintran(a, start + 1);
                    a[i] = temp;
                    transactions.remove(transactions.size() - 1);
                }
            }

            temp = a[ind];
            a[ind] = a[start];
            a[start] = temp;

        }
    }

}

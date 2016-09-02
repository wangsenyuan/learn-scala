package p179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution {

    public static void main(String[] args) {
        //        System.out.println(largestNumber(new int[] {3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[] {120, 12}));
    }

    public static String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return "";
        String[] Snum = new String[num.length];
        for (int i = 0; i < num.length; i++)
            Snum[i] = num[i] + "";

        Arrays.sort(Snum, Solution::cmp);
        if (Snum[Snum.length - 1].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : Snum)
            sb.insert(0, s);

        return sb.toString();
    }

    private static int cmp(String a, String b) {
        return cmp(a.toCharArray(), 0, b.toCharArray(), 0);
    }

    private static int cmp(char[] a, int i, char[] b, int j) {
        if (i == a.length) {
            return -1;
        }

        if (j == b.length) {
            return 1;
        }

        int k = 0;
        for (; i + k < a.length && j + k < b.length; k++) {
            if (a[i + k] < b[j + k]) {
                return -1;
            }
            if (a[i + k] > b[j + k]) {
                return 1;
            }
        }

        if (i + k < a.length) {
            return cmp(a, i + k, b, 0);
        }
        return cmp(a, 0, b, j + k);
    }
}

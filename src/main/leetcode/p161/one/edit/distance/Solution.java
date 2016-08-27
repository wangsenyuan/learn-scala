package p161.one.edit.distance;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }

        return checkTillEnd(s, i + 1, t, j) || checkTillEnd(s, i, t, j + 1) || checkTillEnd(s, i + 1, t, j + 1);
    }

    private boolean checkTillEnd(String s, int i, String t, int j) {
        if (i > s.length() || j > t.length()) {
            return false;
        }
        int a = i;
        int b = j;
        while (a < s.length() && b < t.length() && s.charAt(a) == t.charAt(b)) {
            a++;
            b++;
        }

        if (a < s.length() || b < t.length()) {
            return false;
        }
        if (a - b == 1 || b - a == 1) {
            return true;
        }
        if (a == b && i == j) {
            return true;
        }
        return false;
    }

}

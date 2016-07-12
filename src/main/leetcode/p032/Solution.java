package p032;

/**
 * Created by wangsenyuan on 7/12/16.
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int p = 0;
        int r = 0;
        char[] cs = s.toCharArray();
        int[] stack = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ')' && p > 0 && cs[stack[--p]] == '(') {
                r = p > 0 ? max(r, i - stack[p - 1]) : i + 1;
            } else {
                stack[p++] = i;
            }
        }
        return r;
    }

    private int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }
}

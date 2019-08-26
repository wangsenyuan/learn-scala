package set0000.set000.set030.p032;

/**
 * Created by wangsenyuan on 7/12/16.
 */
public class SolutionJ {

    public int longestValidParentheses(String s) {
        int p = 0;
        int r = 0;
        char[] cs = s.toCharArray();
        int[] stack = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ')' && p > 0 && cs[stack[--p]] == '(') {
                if (p == 0) {
                    r = i + 1;
                } else if (i - stack[p - 1] > r) {
                    r = i - stack[p - 1];
                }
            } else {
                stack[p++] = i;
            }
        }
        return r;
    }

}

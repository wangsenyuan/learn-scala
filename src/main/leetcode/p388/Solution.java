package p388;

/**
 * Created by wangsenyuan on 8/23/16.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath(
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public int lengthLongestPath(String input) {
        char[] cs = input.toCharArray();
        int n = cs.length;
        int[] stack = new int[n];
        int p = 0;

        int level = 0;
        int from = 0;
        boolean isFile = false;
        int res = 0;
        int i = 0;
        for (; i < n; i++) {
            char c = cs[i];
            if (c == '\n') {
                while (p > level) {
                    p--;
                }
                int len = p == 0 ? i - from : i - from + 1 + stack[p - 1];
                if (isFile && len > res) {
                    res = len;
                }

                stack[p++] = len;
                level = 0;
                from = i + 1;
                isFile = false;
            } else if (c == '\t') {
                level++;
                from = i + 1;
            } else if (c == '.') {
                isFile = true;
            }
        }

        if (i > from && isFile) {
            while (p > level) {
                p--;
            }
            int len = p == 0 ? i - from : i - from + 1 + stack[p - 1];
            if (len > res) {
                res = len;
            }
        }

        return res;
    }
}

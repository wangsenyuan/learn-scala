package set0000.set100.set150.p151;

/**
 * Created by wangsenyuan on 8/25/16.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "b    a";
        System.out.println(solution.reverseWords(str));
    }

    public String reverseWords(String s) {
        char[] cs = s.trim().toCharArray();
        int sz = 0;
        for (int i = 0; i < cs.length; i++) {
            if (sz > 0 && cs[sz - 1] == ' ' && cs[i] == ' ') {
                continue;
            }
            cs[sz++] = cs[i];
        }

        for (int i = 0, j = sz - 1; i < j; i++, j--) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
        int from = 0;
        for (int k = 0; k <= sz; k++) {
            if (k < sz && cs[k] != ' ') {
                continue;
            }
            for (int i = from, j = k - 1; i < j; i++, j--) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
            from = k + 1;
        }

        return new String(cs, 0, sz);
    }
}

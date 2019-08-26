package set0000.set400.set460.p467;

/**
 * Created by senyuanwang on 2016/12/4.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findSubstringInWraproundString("zab"));

        System.out.println(solution1.findSubstringInWraproundString("abzabcdf"));
        System.out.println(solution1.findSubstringInWraproundString("a"));
        System.out.println(solution1.findSubstringInWraproundString("zaba"));
        System.out.println(solution1.findSubstringInWraproundString("zabd"));
        System.out.println(solution1.findSubstringInWraproundString("zabc"));
        System.out.println(solution1.findSubstringInWraproundString("abczabc"));
        System.out.println(solution1.findSubstringInWraproundString("abcd"));


    }


    public int findSubstringInWraproundString(String p) {
        int[] length = new int[26];
        int res = 0;
        int curLen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) - 'a' != (p.charAt(i - 1) - 'a' + 1) % 26) {
                curLen = 0;
            }
            curLen++;
            if (curLen > length[p.charAt(i) - 'a']) {
                res += curLen - length[p.charAt(i) - 'a'];
                length[p.charAt(i) - 'a'] = curLen;
            }
        }


        return res;
    }

}

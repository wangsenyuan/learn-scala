package p467;

import java.util.TreeMap;

/**
 * Created by senyuanwang on 2016/12/4.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstringInWraproundString("zab"));

        System.out.println(solution.findSubstringInWraproundString("abzabcdf"));
        System.out.println(solution.findSubstringInWraproundString("a"));
        System.out.println(solution.findSubstringInWraproundString("zaba"));
        System.out.println(solution.findSubstringInWraproundString("zabd"));
        System.out.println(solution.findSubstringInWraproundString("zabc"));
        System.out.println(solution.findSubstringInWraproundString("abczabc"));
        System.out.println(solution.findSubstringInWraproundString("abcd"));


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

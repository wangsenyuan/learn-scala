package p291;

import java.util.HashSet;

/**
 * Created by wangsenyuan on 07/10/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPatternMatch("abab", "redblueredblue"));
    }

    public boolean wordPatternMatch(String pattern, String str) {
        char[] pChar = pattern.toCharArray();
        char[] sChar = str.toCharArray();
        return isMatch(pChar, 0, sChar, 0, new String[26], new HashSet<>());
    }

    public boolean isMatch(char[] pChar, int pStart, char[] sChar, int sStart, String[] pMap,
        HashSet<String> visitSet) {
        if (pStart > pChar.length - 1 && sStart > sChar.length - 1) {
            return true;
        }
        if (pStart > pChar.length - 1 || sStart > sChar.length - 1) {
            return false;
        }

        if (pMap[pChar[pStart] - 'a'] == null) {
            // -----------------------------I added these 4 lines--------------------------
            int endPoint = sChar.length - 1;
            for (int i = pChar.length - 1; i > pStart; i--) {
                endPoint -= pMap[pChar[i] - 'a'] == null ? 1 : pMap[pChar[i] - 'a'].length();
            }
            //-----------------------------------------------------------------------------------
            for (int i = sStart; i <= endPoint; ++i) {
                String ts = new String(sChar, sStart, i - sStart + 1);
                if (visitSet.contains(ts)) {
                    continue;
                }
                pMap[pChar[pStart] - 'a'] = ts;
                visitSet.add(ts);
                if (isMatch(pChar, pStart + 1, sChar, i + 1, pMap, visitSet)) {
                    return true;
                }
                pMap[pChar[pStart] - 'a'] = null;
                visitSet.remove(ts);
            }

            return false;
        }

        String vString = pMap[pChar[pStart] - 'a'];
        if (sStart + vString.length() > sChar.length) {
            return false;
        }
        String ts = new String(sChar, sStart, vString.length());
        if (vString.equals(ts)) {
            return isMatch(pChar, pStart + 1, sChar, sStart + vString.length(), pMap, visitSet);
        }

        return false;
    }
}

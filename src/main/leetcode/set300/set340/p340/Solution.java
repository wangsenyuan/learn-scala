package set300.set340.p340;

/**
 * Created by wangsenyuan on 4/3/16.
 */
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[256];
        int maxLen = 0;
        int j = 0;
        int distinct = 0;

        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] == 0) {
                distinct += 1;
            }
            count[chars[i]] += 1;
            while (distinct > k) {
                count[chars[j]]--;
                if (count[chars[j]] == 0) {
                    distinct -= 1;
                }
                j += 1;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("bacc", 2));
    }
}

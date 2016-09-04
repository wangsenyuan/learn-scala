package p389;

/**
 * Created by senyuanwang on 16/8/28.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }


    public static char findTheDifference(String s, String t) {
        int[] cnts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c = t.charAt(i) - 'a';
            cnts[c]++;
            c = s.charAt(i) - 'a';
            cnts[c]--;
        }

        cnts[t.charAt(t.length() - 1) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (cnts[i] == 1) {
                return (char) ('a' + i);
            }
        }
        return '0';
    }
}

package set0000.set200.set240.p242;

/**
 * Created by senyuanwang on 15/8/1.
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        char[] cs = s.toCharArray();

        for(char c : cs) {
            int x = c - 'a';
            map[x] += 1;
        }

        cs = t.toCharArray();

        for(char c : cs) {
            int x = c - 'a';
            if(map[x] == 0) {
                return false;
            }
            map[x] -= 1;
        }

        for(int x : map) {
            if(x != 0) {
                return false;
            }
        }
        return true;
    }
}

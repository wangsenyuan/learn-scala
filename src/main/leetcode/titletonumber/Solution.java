package titletonumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/3/8.
 */
public class Solution {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), i + 1);
        }
    }


    public static int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int ext = 0;
        int sum = 0;
        int level = 1;
        for (int i = cs.length - 1; i >= 0; i--) {
            char c = cs[i];
            int x = map.get(c);
            x += ext;
            if (x >= 26) {
                x = x - 26;
                ext = 1;
            } else {
                ext = 0;
            }

            sum = sum + x * level;
            level = level * 26;
        }
        if (ext == 1) {
            sum += level;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}

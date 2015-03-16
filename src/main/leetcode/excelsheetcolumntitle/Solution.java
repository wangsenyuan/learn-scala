package excelsheetcolumntitle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution {

    private static final char[] map = new char[26];

    static {
        for (int i = 0; i < 26; i++) {
            map[i] = (char) ('A' + i);
        }
    }

    public static String convertToTitle(int n) {
        char[] chars = new char[32];
        int index = 0;
        int x = n;
        while (x > 0) {
            x -= 1;
            int y = x % 26;
            chars[index++] = map[y];
            x = x / 26;
        }

        String result = "";

        for (int i = index - 1; i >= 0; i--) {
            result += chars[i];
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}

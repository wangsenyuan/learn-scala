package set0000.set400.set400.p409;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 16/10/2.
 */
public class Solution1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/leetcode/set0000.set400.set0000.set400.p409/input1.txt"))) {
            String line = br.readLine();
            Solution1 solution1 = new Solution1();
            System.out.println(solution1.longestPalindrome(line));
        }
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> cnts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnts.containsKey(c)) {
                cnts.put(c, cnts.get(c) + 1);
            } else {
                cnts.put(c, 1);
            }
        }

        int sum = 0;
        int mid = 0;
        for (int v : cnts.values()) {
            if (v % 2 == 0) {
                sum += v;
                continue;
            }
            mid = 1;
            sum += v - 1;
        }
        return sum + mid;
    }
}

package problems.simple.p013.numtoroman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/10.
 */
public class Main {
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int times = num / nums[i];
            num -= nums[i] * times;
            for (; times > 0; times--) {
                res.append(symbols[i]);
            }
            ++i;
        }
        return res.toString();
    }

    public static Map<Character, Integer> countOccurence(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(intToRoman(i));
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < cs.length; ) {
            j = i;
            while (j < cs.length && cs[j] == cs[i]) {
                j += 1;
            }
            result.put(cs[i], j - i);
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(intToRoman(scanner.nextInt()));
        Map<Character, Integer> result = countOccurence(scanner.nextInt());
        char[] cs = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        for(char c : cs) {
            if(result.containsKey(c)) {
                System.out.println(c + " " + result.get(c));
            }
        }
    }
}

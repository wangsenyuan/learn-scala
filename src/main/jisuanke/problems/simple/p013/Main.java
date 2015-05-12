package problems.simple.p013;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/10.
 */
public class Main {
    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(intToRoman(scanner.nextInt()));
    }
}

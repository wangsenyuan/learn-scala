package fractiontorecursiondecimal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/3/15.
 */
public class Solution {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            result.append(".0");
            return result.toString();
        }
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}

package p166;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 8/31/16.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 6));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        sb.append(dividend / divisor);
        long reminder = (dividend % divisor);
        if (reminder == 0) {
            return sb.toString();
        }

        sb.append(".");

        Map<Long, Integer> pos = new HashMap<>();
        while (reminder > 0) {
            if (pos.get(reminder) != null) {
                sb.insert(pos.get(reminder), "(");
                sb.append(")");
                break;
            }

            pos.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / divisor);
            reminder %= divisor;
        }
        return sb.toString();
    }
}

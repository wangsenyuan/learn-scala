package fractiontorecursiondecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/3/15.
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "ERROR CASE";
        }

        StringBuilder result = new StringBuilder();

        //the sign
        result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);

        num %= den;
        if (num == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (num != 0) {
            map.put(num, result.length());

            num *= 10;
            result.append(num / den);
            num %= den;
            Integer remainderIndex = map.get(num);
            if (remainderIndex != null) {
                result.insert(remainderIndex, "(");
                result.append(")");
                break;
            }
        }

        return result.toString();
    }
}

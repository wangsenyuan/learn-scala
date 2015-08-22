package strobogrammatic.number.p247;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {

    public List<String> findStrobogrammatic(int n) {
        List<String> result = recFind(n);
        if (n > 1) {
            for (Iterator<String> iter = result.iterator(); iter.hasNext(); ) {
                String str = iter.next();
                if (str.charAt(0) == '0') {
                    iter.remove();
                }
            }
        }

        return result;
    }

    public List<String> recFind(int n) {
        if (n < 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        if (n == 0) {
            result.add("");
            return result;
        }

        if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }

        List<String> subResult = recFind(n - 2);

        for (String sub : subResult) {
            result.add("0" + sub + "0");
            result.add("1" + sub + "1");
            result.add("8" + sub + "8");
            result.add("6" + sub + "9");
            result.add("9" + sub + "6");
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findStrobogrammatic(2));
    }
}

package p282;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 2016/10/6.
 */
public class Solution {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        List<String> res = new Solution().addOperators(num, target);
        res.forEach(System.out::println);
    }

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0)
            return rst;
        char[] cs = num.toCharArray();
        long x = 0;

        for (int j = 0; j < cs.length; j++) {
            if (j > 0 && cs[j] == '0') {
                break;
            }
            x = x * 10 + cs[j] - '0';
            if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                break;
            }
            int y = (int) x;
            addOperators(rst, "" + y, cs, j + 1, target, y, y);
        }
        return rst;
    }

    public void addOperators(List<String> res, String path, char[] num, int i, int target, int got, int mul) {
        if (i == num.length) {
            if (got == target) {
                res.add(path);
            }
            return;
        }
        long x = 0;
        for (int j = i; j < num.length; j++) {
            if (j > i && num[i] == '0') {
                break;
            }
            x = x * 10 + num[j] - '0';
            if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                break;
            }
            int y = (int) x;
            addOperators(res, path + "+" + x, num, j + 1, target, got + y, y);
            addOperators(res, path + "-" + x, num, j + 1, target, got - y, -y);
            addOperators(res, path + "*" + x, num, j + 1, target, got - mul + mul * y, mul * y);
        }
    }
}

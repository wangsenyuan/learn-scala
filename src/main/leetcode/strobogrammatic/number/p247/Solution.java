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
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else {
            recFind(n - 2, "1", "1", res);
            recFind(n - 2, "8", "8", res);
            recFind(n - 2, "9", "6", res);
            recFind(n - 2, "6", "9", res);
        }

        return res;
    }

    public void recFind(int n, String left, String right, List<String> res) {
        if (n == 0) {
            res.add(left + right);
            return;
        }

        if (n == 1) {
            res.add(left + "0" + right);
            res.add(left + "1" + right);
            res.add(left + "8" + right);
            return;
        }
        recFind(n - 2, left + "0", "0" + right, res);
        recFind(n - 2, left + "1", "1" + right, res);
        recFind(n - 2, left + "8", "8" + right, res);
        recFind(n - 2, left + "6", "9" + right, res);
        recFind(n - 2, left + "9", "6" + right, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findStrobogrammatic(4));
    }
}

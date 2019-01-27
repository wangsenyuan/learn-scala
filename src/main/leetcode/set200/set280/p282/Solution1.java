package set200.set280.p282;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 2016/10/6.
 */
public class Solution1 {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        List<String> res = new Solution1().addOperators(num, target);
        res.forEach(System.out::println);
    }

    public List<String> addOperators(String num, int target) {
        char[] digit = num.toCharArray(), path = new char[num.length() * 2];
        List<String> ans = new ArrayList();
        long pureNum = 0;
        for (int i = 0; i < digit.length; i++) {
            pureNum = pureNum * 10 + (digit[i] - '0');
            path[i] = digit[i];
            dfs(i + 1, i + 1, 0, pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
        return ans;
    }

    private void dfs(int ip, int id, long toAdd, long toMult, char[] path, char[] digit, int target, List<String> ans) {
        if (id == digit.length && toAdd + toMult == target) {
            ans.add(String.valueOf(path, 0, ip));
            return;
        }
        long pureNum = 0;
        for (int i = 0; id + i < digit.length; i++) {
            pureNum = pureNum * 10 + (digit[id + i] - '0');
            path[ip + i + 1] = digit[id + i];
            path[ip] = '+';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, pureNum, path, digit, target, ans);
            path[ip] = '-';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, -pureNum, path, digit, target, ans);
            path[ip] = '*';
            dfs(ip + i + 2, id + i + 1, toAdd, toMult * pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
    }
}

package set200.set240.p241;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by senyuanwang on 15/7/27.
 */
public class Solution1 {
    private Map<String, List<Integer>> cache = new HashMap<>();

    private List<Integer> diffWaysToCompute(char[] cs, int start, int end) {
        String key = new String(cs, start, end - start);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean isNumber = true;
        int num = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isOperator(cs[i])) {
                isNumber = false;
                List<Integer> prev = diffWaysToCompute(cs, start, i);
                List<Integer> suff = diffWaysToCompute(cs, i + 1, end);
                combineResult(result, prev, suff, cs[i]);
            }
            if (isNumber) {
                num = num * 10 + (cs[i] - '0');
            }
        }

        if (isNumber) {
            result.add(num);
        }

        cache.put(key, result);
        return result;
    }

    private void combineResult(List<Integer> result, List<Integer> prev, List<Integer> suff, char op) {
        for (int x : prev) {
            for (int y : suff) {
                result.add(calculate(x, y, op));
            }
        }
    }

    private int calculate(int x, int y, char op) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
        }
        return 0;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input.toCharArray(), 0, input.length());
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out
            .println(solution.diffWaysToCompute("2-4").stream().map(x -> "" + x).collect(Collectors.joining(",")));
    }
}

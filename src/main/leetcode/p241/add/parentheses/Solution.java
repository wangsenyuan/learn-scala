package p241.add.parentheses;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by senyuanwang on 15/7/27.
 */
public class Solution {
    private final static long base = 100001;
    private Map<Long, List<Integer>> cache = new HashMap<>();

    private List<Integer> diffWaysToCompute(char[] cs, int start, int end) {
        long key = base * start + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean isNumber = true;

        for (int i = start; i < end; i++) {
            if (isOperator(cs[i])) {
                isNumber = false;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (isNumber) {
            result.addAll(toNum(cs, start, end));
        } else {

            for (int i = start; i < end; i++) {
                if (isOperator(cs[i])) {
                    List<Integer> prev = diffWaysToCompute(cs, start, i);
                    List<Integer> suff = diffWaysToCompute(cs, i + 1, end);
                    result.addAll(combineResult(prev, suff, cs[i]));
                }
            }

            return result;
        }

        cache.put(key, result);
        return result;
    }

    private List<Integer> combineResult(List<Integer> prev, List<Integer> suff, char op) {
        List<Integer> result = new ArrayList<>();

        for (int x : prev) {
            for (int y : suff) {
                result.add(calculate(x, y, op));
            }
        }

        return result;
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

    private List<Integer> toNum(char[] cs, int start, int end) {
        int num = 0;

        for (int i = start; i < end; i++) {
            if (cs[i] == ' ') {
                continue;
            }
            num = num * 10 + (cs[i] - '0');
        }
        List<Integer> result = new ArrayList<>(1);
        result.add(num);
        return result;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input.toCharArray(), 0, input.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-4").stream().map(x -> "" + x).collect(Collectors.joining(",")));
    }
}

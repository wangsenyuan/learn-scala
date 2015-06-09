package p224.basic.caculator;

/**
 * Created by senyuanwang on 15/6/9.
 */
public class Solution {

    public static int calculate(String s) {
        char[] cs = s.toCharArray();
        return calculate(cs, 0, cs.length);
    }

    public static int calculate(char[] cs, int start, int end) {
        int result = 0;
        char op = '+';
        for (int i = start; i < end; ) {
            if (isOperator(cs[i])) {
                op = cs[i];
                i++;
                continue;
            }

            while (i < end && isRedundant(cs[i])) {
                i++;
            }

            if (i == end) {
                break;
            }

            int num = 0;

            if (cs[i] == '(') {
                int level = 0;
                int j = i + 1;
                for (; j < end; j++) {
                    if (cs[j] == '(') {
                        level += 1;
                    } else if (cs[j] == ')') {
                        level -= 1;
                    }
                    if (level < 0) {
                        break;
                    }
                }
                num = calculate(cs, i + 1, j);
                i = j + 1;
            } else if (isNumber(cs[i])) {
                while (i < end && isNumber(cs[i])) {
                    num = num * 10 + (cs[i] - '0');
                    i++;
                }
            }

            if (num != 0) {
                result = process(op, result, num);
            }
        }

        return result;
    }

    private static int process(char op, int a, int b) {
        int c = 0;
        switch (op) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            default:
                throw new IllegalArgumentException("unknown operator " + c);
        }
        return c;
    }

    private static boolean isRedundant(char c) {
        return c == ' ';
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));

        System.out.println(calculate("2-(5-6)"));

        System.out.println(calculate("5    "));
    }

}

package p227.basic.caculator;

/**
 * Created by senyuanwang on 15/6/22.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("3+2*2 = " + calculate("3+2*2"));
        System.out.println(" 3/2  = " + calculate(" 3/2 "));
        System.out.println(" 3+5 / 2  = " + calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        char[] cs = s.toCharArray();

        Stack stack = new Stack();
        for (int i = 0; i < cs.length; ) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }

            if (isMul(cs[i]) || isAdd(cs[i])) {
                stack.addOp(cs[i]);
                i++;
                continue;
            }
            int num = 0;
            while (i < cs.length && isNum(cs[i])) {
                num = num * 10 + (cs[i] - '0');
                i++;
            }
            stack.addNum(num);
        }

        return stack.eval();
    }

    static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean isMul(char c) {
        return c == '*' || c == '/';
    }

    static boolean isAdd(char c) {
        return c == '+' || c == '-';
    }

    static class Stack {
        int[] nums = new int[3];
        int pnum = -1;
        char[] ops = new char[2];
        int pop = -1;

        public void addOp(char op) {
            if (isAdd(op) && pop == 0) {
                int b = nums[pnum--];
                int a = nums[pnum--];
                int c = calc(a, b, ops[pop--]);
                nums[++pnum] = c;
            }
            ops[++pop] = op;
        }

        public void addNum(int num) {
            nums[++pnum] = num;
            if (pop >= 0 && isMul(ops[pop])) {
                int b = nums[pnum--];
                int a = nums[pnum--];
                int c = calc(a, b, ops[pop--]);
                nums[++pnum] = c;
            }
        }

        int calc(int a, int b, char op) {
            int c = 0;
            switch (op) {
                case '+':
                    c = a + b;
                    break;
                case '-':
                    c = a - b;
                    break;
                case '*':
                    c = a * b;
                    break;
                case '/':
                    c = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("unknown operator " + c);
            }
            return c;
        }

        public int eval() {
            if (pnum == 0) {
                return nums[pnum--];
            } else {
                int b = nums[pnum--];
                int a = nums[pnum--];
                char c = ops[pop--];
                return calc(a, b, c);
            }
        }
    }
}

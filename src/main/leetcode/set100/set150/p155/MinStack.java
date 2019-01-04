package set100.set150.p155;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 8/26/16.
 */
public class MinStack {
    private int[] stack;
    private int[] min;
    private int p = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new int[100];
        this.min = new int[100];
    }

    public void push(int x) {
        if (p == this.stack.length) {
            this.stack = Arrays.copyOf(stack, p + 100);
            this.min = Arrays.copyOf(min, p + 100);
        }
        stack[p] = x;

        if (p == 0 || min[p - 1] >= x) {
            min[p] = x;
        } else {
            min[p] = min[p - 1];
        }

        p++;
    }

    public void pop() {
        p--;
    }

    public int top() {
        return stack[p - 1];
    }

    public int getMin() {
        return min[p - 1];
    }
}

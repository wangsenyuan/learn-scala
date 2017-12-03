package p739;

public class Main {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int p = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (p > 0 && temperatures[stack[p - 1]] < temperatures[i]) {
                res[stack[p - 1]] = i - stack[p - 1];
                p--;
            }
            stack[p++] = i;
        }

        return res;
    }
}

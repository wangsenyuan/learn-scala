package set000.set080.p084;

/**
 * Created by senyuanwang on 16/7/28.
 */
public class Solution1 {
    public static int largestRectangleArea(int[] height) {
        int n = height.length;

        int area = 0;
        int[] stack = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            int k = i;
            while (p > 0 && height[stack[p - 1]] > h) {
                int j = stack[p - 1];
                area = max(area, (i - j) * height[j]);
                k = j;
                height[j] = h;
                p--;
            }

            stack[p++] = k;
            area = max(area, h);
        }

        while (p > 0) {
            int i = stack[--p];
            area = Math.max(area, (n - i) * height[i]);
        }

        return area;
    }

    static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }


    public static void main(String[] args) {
        int[] heights = {5, 4, 1, 2};
        System.out.println(largestRectangleArea(heights));
    }
}

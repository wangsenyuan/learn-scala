package set300.set350.p354;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 6/8/16.
 */
public class Solution1 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            int c = a[0] - b[0];
            if (c != 0) {
                return c;
            }
            return b[1] - a[1];
        });

        return longestIncreasingSequence(envelopes);
    }

    private int longestIncreasingSequence(int[][] envelopes) {
        int n = envelopes.length;
        int[] m = new int[n + 1];
        Arrays.fill(m, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = 1;
            int h = max;
            int[] a = envelopes[i];
            while (l <= h) {
                int mid = (l + h) / 2;
                int[] b = envelopes[m[mid]];
                if (b[0] < a[0] && b[1] < a[1]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }

            m[l] = i;
            max = Math.max(max, l);
        }


        return max;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxEnvelopes(new int[][] {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}}));
        System.out.println(solution1.maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(solution1.maxEnvelopes(
            new int[][] {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
    }
}

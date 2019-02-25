package set300.set390.p391;

import java.util.Arrays;

/**
 * Created by senyuanwang on 16/8/28.
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] rects = {{0, 0, 4, 1}, {7, 0, 8, 2}, {6, 2, 8, 3}, {5, 1, 6, 3}, {4, 0, 5, 1}, {6, 0, 7, 2}, {4, 2, 5, 3}, {2, 1, 4, 3}, {0, 1, 2, 2}, {0, 2, 2, 3}, {4, 1, 5, 2}, {5, 0, 6, 1}};
        System.out.println(isRectangleCover(rects));


    }

    public static boolean isRectangleCover(int[][] rectangles) {
        int[] rect = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        Arrays.sort(rectangles, (int[] a, int[] b) -> {
            for (int i = 0; i < 4; i++) {
                if (a[i] < b[i]) {
                    return -1;
                } else if (a[i] > b[i]) {
                    return 1;
                }
            }
            return 0;
        });

        long area = 0;

        for (int i = 0; i < rectangles.length; i++) {
            int[] a = rectangles[i];
            area += area(a);
            if (a[0] < rect[0]) {
                rect[0] = a[0];
            }

            if (a[1] < rect[1]) {
                rect[1] = a[1];
            }

            if (a[2] > rect[2]) {
                rect[2] = a[2];
            }

            if (a[3] > rect[3]) {
                rect[3] = a[3];
            }

            for (int j = i + 1; j < rectangles.length; j++) {
                int[] b = rectangles[j];
                if (b[0] >= a[2]) {
                    break;
                }
                if (b[1] >= a[3]) {
                    break;
                }

                if (a[0] <= b[0] && a[1] <= b[1]) {
                    return false;
                }
            }
        }

        if (area != area(rect)) {
            return false;
        }

        return true;
    }

    private static long area(int[] rectangle) {
        return ((long) rectangle[3] - (long) rectangle[1]) * ((long) rectangle[2] - (long) rectangle[0]);
    }
}

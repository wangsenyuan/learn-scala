package p452;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/11/6.
 */
public class Solution {

    public static void main(String[] args) {
        //int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (int[] a, int[] b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            } else {
                return 0;
            }
        });

        int overlap = 1;
        int[] first = points[0];

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (first[1] >= point[0]) {
                continue;
            }
            overlap++;
            first = point;
        }

        return overlap;
    }
}

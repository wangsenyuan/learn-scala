package p406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 9/25/16.
 */
public class Solution {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int n = people.length;

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] x = people[i];
            int k = x[1];
            res.add(k, x);
        }

        return res.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for (int[] x : res) {
            System.out.println(x[0] + " " + x[1]);
        }

    }
}

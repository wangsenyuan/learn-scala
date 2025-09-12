package fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {

    public static void main(String[] args) {
        //        test1();
        test2();
    }

    public static void test1() {
        List<List<Integer>> sample = new ArrayList<>();
        sample.add(Arrays.asList(1, 2, 3));
        sample.add(Arrays.asList(4, 5, 6));
        sample.add(Arrays.asList(7, 8, 9));
        sample.add(Arrays.asList(10, 11, 12));
        sample.add(Arrays.asList(13, 14, 15));
        List<Integer> result = solve(sample);
        result.forEach(x -> System.out.printf("%d ", x));
    }

    public static void test2() {
        List<List<Integer>> sample = new ArrayList<>();
        sample.add(Arrays.asList(1, 2, 3, 4, 5));
        sample.add(Arrays.asList(6, 7, 8, 9, 10));
        sample.add(Arrays.asList(100, 120, 130, 140, 150));
        sample.add(Arrays.asList(11, 12, 13, 14, 15));
        sample.add(Arrays.asList(16, 17, 18, 19, 20));
        List<Integer> result = solve(sample);
        result.forEach(x -> System.out.printf("%d ", x));
    }

    public static List<Integer> solve(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] a = new int[n][m];
        int rid = 0;
        for (List<Integer> row : grid) {
            for (int i = 0; i < m; i++) {
                a[rid][i] = row.get(i);
            }
            rid++;
        }
        List<Integer> result = new ArrayList<>();

        int[] box = {0, 0, n - 1, m - 1};
        while (box[0] <= box[2] && box[1] <= box[3]) {
            // top
            for (int j = box[1]; j <= box[3]; j++) {
                result.add(a[box[0]][j]);
            }

            if (box[0] < box[2]) {
                // right
                for (int i = box[0] + 1; i <= box[2]; i++) {
                    result.add(a[i][box[3]]);
                }

                if (box[1] < box[3]) {
                    // bottom
                    for (int j = box[3] - 1; j >= box[1]; j--) {
                        result.add(a[box[2]][j]);
                    }
                    // left
                    for (int i = box[2] - 1; i > box[0]; i--) {
                        result.add(a[i][box[1]]);
                    }
                }
            }
            box[0]++;
            box[1]++;
            box[2]--;
            box[3]--;
        }


        return result;
    }
}

package set1000.set1000.set1030.p1037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // f(x, y) == z
        // f(x - 1, y) < z
        // f(x, y - 1) < z
        // f(x + 1, y) > z
        // f(x, y + 1) > z
        List<List<Integer>> res = new ArrayList<>();

        for (int x = 1; x <= 1000; x++) {
            int y = fx(x, customfunction, z);
            if (y > 0 && y <= 1000 && customfunction.f(x, y) == z) {
                res.add(Arrays.asList(x, y));
            }
        }

        return res;
    }

    private static int fx(int x, CustomFunction customFunction, int z) {
        int left = 1;
        int right = 1001;

        while (left < right) {
            int mid = (left + right) / 2;
            if (customFunction.f(x, mid) > z) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // f(x, right) > z
        // f(x, right) <= z
        return right - 1;
    }
}


/*
 * // This is the custom function interface.
 */
interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y);
};

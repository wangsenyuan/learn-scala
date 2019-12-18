package set1000.set1200.set1230.p1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 */
interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    int f(int x, int y);
};


public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1;
        while (x <= 1000) {
            int y = 1;
            while (y <= 1000 && customfunction.f(x, y) < z) {
                y += 1;
            }

            while (y <= 1000 && customfunction.f(x, y) == z) {
                res.add(Arrays.asList(x, y));
                y += 1;
            }
            x += 1;
        }

        return res;
    }
}

package p386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 16/8/22.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.lexicalOrder(999);
        result.forEach(System.out::println);
        System.out.println("++++++++++");
        System.out.println(result.size());
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);

        for (int i = 1; i < 10; i++) {
            process(i, n, result);
        }

        return result;
    }

    private void process(int x, int n, List<Integer> result) {
        if (x > n) {
            return;
        }

        result.add(x);
        for (int i = 0; i < 10; i++) {
            process(x * 10 + i, n, result);
        }
    }
}
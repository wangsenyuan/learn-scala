package set0000.set300.set380.p386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 16/8/22.
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<Integer> result = solution1.lexicalOrderQuick(999);
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

    public List<Integer> lexicalOrderQuick(int n) {
        List<Integer> result = new ArrayList<>(n);

        int current = 1;
        for (int i = 1; i <= n; i++) {
            result.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else if (current < n && current % 10 < 9) {
                current++;
            } else {
                while ((current / 10) % 10 == 9) {
                    current /= 10;
                }
                current = current / 10 + 1;
            }

        }

        return result;
    }
}

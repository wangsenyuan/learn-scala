package p216.combination.sum;

import java.util.*;

/**
 * Created by senyuanwang on 15/5/24.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        List<List<Integer>> result = combinationSum3(k, n);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static <T> List<T> inList(T t) {
        List<T> list = new ArrayList<T>();
        list.add(t);
        return list;
    }

    private static List<List<Integer>> combinationSumK(int k, int n, int x) {
/*        P p = new P(k, n);
        if (result.containsKey(p)) {
            return result.get(p);
        }*/
        if (k == 1 && n < 10 && x < n) {
            List<Integer> list = inList(n);
            return inList(list);
        } else if (k == 1) {
            return Collections.emptyList();
        }

        List<List<Integer>> theLists = new ArrayList<List<Integer>>();
        for (int i = x + 1; i < 10; i++) {
            List<List<Integer>> lists = combinationSumK(k - 1, n - i, i);
            if (!lists.isEmpty()) {
                for (List<Integer> nums : lists) {
                    theLists.add(append(i, nums));
                }
            }
        }
//        result.put(p, theLists);
        return theLists;
    }

    private static List<Integer> append(int x, List<Integer> nums) {
        List<Integer> list = inList(x);
        for (Integer num : nums) {
            list.add(num);
        }
        return list;
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSumK(k, n, 0);
    }
}

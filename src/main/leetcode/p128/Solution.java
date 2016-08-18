package p128;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wangsenyuan on 8/18/16.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        //int[] nums = new int[] {0, -1};
        int[] nums = new int[] {1, 3, 5, 2, 4};
        //int[] nums =
        //  new int[] {-3, 2, 8, 5, 1, 7, -8, 2, -8, -4, -1, 6, -6, 9, 6, 0, -7, 4, 5, -4, 8, 2, 0, -2, -6, 9, -4, -1};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        int res = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                continue;
            }
            int left = 0;
            if (map.containsKey(n - 1)) {
                left = map.get(n - 1);
            }
            int right = 0;
            if (map.containsKey(n + 1)) {
                right = map.get(n + 1);
            }
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);

            // keep track of the max length
            if (sum > res) {
                res = sum;
            }

            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            if (left > 0) {
                map.put(n - left, sum);
            }

            if (right > 0) {
                map.put(n + right, sum);
            }

        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            Integer lt = map.floorKey(num);

            if ((lt != null && map.get(lt) >= num)) {
                continue;
            }

            Integer gt = map.ceilingKey(num);

            if (lt != null && gt != null && map.get(lt) + 1 == num && num + 1 == gt) {
                map.put(lt, map.remove(gt));
            } else if (gt != null && num + 1 == gt) {
                map.put(num, map.remove(gt));
            } else if (lt != null && map.get(lt) + 1 == num) {
                map.put(lt, num);
            } else {
                map.put(num, num);
            }
        }

        int maxRange = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value - key > maxRange) {
                maxRange = value - key;
            }
        }
        return maxRange + 1;
    }

}

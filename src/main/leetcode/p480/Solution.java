package p480;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by senyuanwang on 2017/1/8.
 */
public class Solution {

    public static void main(String[] args) {
        //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1, 2, 3, 4, 2, 3, 1, 4, 2};
        double[] res = new Solution().medianSlidingWindow(nums, 3);
        Arrays.stream(res).forEach(a -> System.out.printf("%f ", a));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new double[0];
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek()) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }

            if (i >= k - 1) {
                if (k % 2 == 1) {
                    res[idx] = (1.0 * maxHeap.peek());
                } else {
                    res[idx] = (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);
                }
                idx += 1;
                int toRemove = nums[i - k + 1];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            }
        }

        return res;
    }
}

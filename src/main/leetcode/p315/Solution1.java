package p315;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 28/10/2016.
 */
public class Solution1 {

    class Node {
        Node left, right;
        int val, less, dup = 1;

        public Node(int v, int s) {
            val = v;
            less = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length];

        Node node = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            node = insert(nums[i], i, ans, node, 0);
        }

        List<Integer> result = new ArrayList<>(nums.length);
        for (int x : ans) {
            result.add(x);
        }

        return result;
    }


    private Node insert(int num, int index, int[] ans, Node node, int lessThanSelf) {
        if (node == null) {
            ans[index] = lessThanSelf;
            node = new Node(num, 0);
        } else if (node.val == num) {
            node.dup += 1;
            ans[index] = lessThanSelf + node.less;
        } else if (node.val > num) {
            node.less += 1;
            node.left = insert(num, index, ans, node.left, lessThanSelf);
        } else {
            node.right = insert(num, index, ans, node.right, lessThanSelf + node.dup + node.less);
        }
        return node;
    }
}

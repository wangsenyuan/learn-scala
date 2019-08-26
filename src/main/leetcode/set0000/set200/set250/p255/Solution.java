package set0000.set200.set250.p255;

/**
 * Created by senyuanwang on 15/8/27.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length);
    }

    public boolean verifyPreorder(int[] seq, int start, int end) {
        if (start + 1 >= end) {
            return true;
        }

        int root = seq[start];

        int i = start + 1;
        while (i < end && seq[i] < root) {
            i++;
        }

        if (i < end) {
            int j = i;
            while (j < end && seq[j] > root) {
                j++;
            }
            if (j < end) {
                return false;
            }

            return verifyPreorder(seq, start + 1, i) && verifyPreorder(seq, i, end);
        } else {
            return verifyPreorder(seq, start + 1, end);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] seq = {2, 3, 1};
        System.out.println(solution.verifyPreorder(seq));
    }
}

package create.max.number.p321;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by senyuanwang on 15/12/23.
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<int[]> one = generateList(nums1, nums2, k);// give all possible
        // result
        return compare(one, k);// find the maximum among all possible result;
    }

    public List<int[]> generateList(int[] n1, int[] n2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (n1 == null || n2 == null || k == 0)
            return res;
        for (int i = 0; i <= k; i++) {// find out how many elements each array
            // would contribute to the final result
            int[] a = helper(n1, i);
            int[] b = helper(n2, k - i);
            if (a != null && b != null)
                res.add(merge(a, b));// merge two array into one and add it to
            // the possible result list
        }
        return res;
    }

    public int[] helper(int[] arr, int k) {// generate maximum number out of one
        // array
        if (k == 0)
            return new int[0];
        else if (k > arr.length)
            return null;
        else if (k == arr.length)
            return arr;

        int[] res = new int[k];
        int ind = 0;
        for (int i = 0; i < k; i++) {
            int max = ind;
            for (int j = ind; j <= arr.length - (k - i); j++) {// within the
                // range which
                // allow at
                // least k-i
                // numbers
                // following,
                // find the
                // maximum
                if (arr[max] < arr[j])
                    max = j;
            }
            res[i] = arr[max];
            ind = max + 1;
        }
        return res;
    }

    public int[] merge(int[] a, int[] b) {// merge two array into one with
        // maximum possible number;
        int[] res = new int[a.length + b.length];
        int aind = 0, bind = 0;
        while (aind < a.length && bind < b.length) {
            if (a[aind] > b[bind]) {
                res[aind + bind] = a[aind++];
            } else if (a[aind] < b[bind]) {
                res[aind + bind] = b[bind++];
            } else {// the only trick part is here
                int at = aind;
                int bt = bind;
                while (at < a.length && bt < b.length && a[at] == b[bt]) {
                    at++;
                    bt++;
                }
                if (at < a.length && bt < b.length) {// both pointer didn't
                    // reach the end, means
                    // there's two entry not
                    // equal, so we can
                    // compare;
                    if (a[at] < b[bt])
                        res[aind + bind] = b[bind++];
                    else
                        res[aind + bind] = a[aind++];
                } else {
                    if (at == a.length)
                        res[aind + bind] = b[bind++];
                    else if (bt == b.length)
                        res[aind + bind] = a[aind++];
                }
            }
        }
        while (aind < a.length)
            res[aind + bind] = a[aind++];
        while (bind < b.length)
            res[aind + bind] = b[bind++];
        return res;
    }

    public int[] compare(List<int[]> list, int k) {
        for (int i = 0; i < k; i++) {// position of the current number
            int max = list.get(0)[i];
            for (int j = 0; j < list.size(); j++) {// find the maximum number
                // for this position
                max = Math.max(list.get(j)[i], max);
            }

            for (Iterator<int[]> iter = list.iterator(); iter.hasNext(); ) {
                int[] nums = iter.next();
                if (nums[i] != max) {
                    iter.remove();
                }
            }
        }
        return list.get(0);// the remaining int[] is the result we want;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        Solution solution = new Solution();
        int[] result = solution.maxNumber(nums1, nums2, 5);
        System.out.println(Arrays.asList(result));
    }
}

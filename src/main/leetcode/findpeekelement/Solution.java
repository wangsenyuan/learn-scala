package findpeekelement;

/**
 * Created by senyuanwang on 15/3/15.
 */
public class Solution {
    public int findPeakElement(int[] num) {
        int l = 0;
        int r = num.length - 1;
        int mid = r / 2;
        while (l < r) {
            if (num[mid] < num[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return l;
    }
}


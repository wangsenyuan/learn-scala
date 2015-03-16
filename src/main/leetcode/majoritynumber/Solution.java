package majoritynumber;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution {

    public int majorityElement(int[] num) {
        int n = num.length;
        int i = 0;
        int result = 0;
        int count = 0;
        for (; i < n; ++i) {
            if (count == 0 || result == num[i]) {
                result = num[i];
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}

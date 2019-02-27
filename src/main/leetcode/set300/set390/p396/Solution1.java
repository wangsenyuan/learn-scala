package set300.set390.p396;

/**
 * Created by wangsenyuan on 07/12/2016.
 */
public class Solution1 {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        long f = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            f += i * A[i];
        }

        long res = f;
        for (int k = 1; k < n; k++) {
            f = f + sum - n * A[n - k];
            if (f > res) {
                res = f;
            }
        }
        return (int) res;
    }
}

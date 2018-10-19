package set000.set000.p004;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by wangsenyuan on 6/15/16.
 */
public class JSolution {

    public double findMedianSortedArrays(int A[], int B[]) {
        int K = A.length + B.length;
        if (K % 2 == 0)
            return (findMedianSortedArrays(A, B, (K - K / 2)) + findMedianSortedArrays(A, B, (K - (K / 2 + 1)))) / 2;
        else
            return findMedianSortedArrays(A, B, K - (K / 2 + 1));
    }

    // k is the number of elements to REMOVE, or "Chop off"
    public double findMedianSortedArrays(int A[], int B[], int K) {
        int highA = A.length;
        int highB = B.length;
        while (K > 0 && highA > 0 && highB > 0) {
            int chopA = max(1, min(K / 2, highA / 2));
            int chopB = max(1, min(K / 2, highB / 2));

            int midA = highA - chopA;
            int midB = highB - chopB;
            if (A[midA] < B[midB]) {
                // here A[0 .. midA] < B[midB], and we know that B[0 .. midB-1] < B[midB], so B[midB..highB] can not possibly be within the first (len(A) + len(B) - K) elements, and can be safely removed.
                highB = midB;
                K = K - chopB;
            } else {
                highA = midA;
                K = K - chopA;
            }
        }

        if (highA == 0 && highB == 0)
            return 0;
        if (highA == 0)
            return B[highB - 1 - K];
        if (highB == 0)
            return A[highA - 1 - K];
        return max(A[highA - 1], B[highB - 1]);
    }
}

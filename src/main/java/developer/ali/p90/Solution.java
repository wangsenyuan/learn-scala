package developer.ali.p90;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int x, int[] A, int[] B) {
        // find most numbers that a[i] + b[j] > x
        Arrays.sort(A);
        reverse(A);
        Arrays.sort(B);
        //        reverse(b);

        int cnt = 0;

        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            int a = A[i];
            int k = j;
            while (j < n && a + B[j] < x) {
                j++;
            }
            cnt += j - k;
            i++;
            j++;
        }

        return n - cnt;
    }

    private static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            i++;
            j--;
        }
    }
}

package set1000.set1000.set1090.p1095;

import java.util.Arrays;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface MountainArray {
    public int get(int index);

    public int length();
}


public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        get(mountainArr, arr, 0);
        get(mountainArr, arr, n - 1);

        if (arr[0] > target && arr[n - 1] > target) {
            return -1;
        }
        // first find the peek

        int left = 0;
        int right = n - 1;
        // x[0] = arr[1] - arr[0].... x[n-2] = arr[n-1] - arr[n-2]
        while (left < right) {
            // arr[right - 2] > arr[right - 1]
            int mid = (left + right) / 2;
            int a = get(mountainArr, arr, mid);
            int b = get(mountainArr, arr, mid - 1);
            if (b > a) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // peek is at right - 1
        int peek = right - 1;
        if (get(mountainArr, arr, peek) < target) {
            return -1;
        }

        left = 0;
        right = peek + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int a = get(mountainArr, arr, mid);
            if (a >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (get(mountainArr, arr, right) == target) {
            return right;
        }
        left = peek;
        right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            int a = get(mountainArr, arr, mid);
            if (a <= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (get(mountainArr, arr, right) == target) {
            return right;
        }
        return -1;
    }

    private static int get(MountainArray mountainArray, int[] arr, int i) {
        if (arr[i] < 0) {
            arr[i] = mountainArray.get(i);
        }
        return arr[i];
    }
}

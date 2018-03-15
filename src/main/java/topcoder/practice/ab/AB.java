package topcoder.practice.ab;

import java.util.function.Predicate;

public class AB {
    public static void main(String[] args) {
        AB ab = new AB();

        System.out.println(ab.createString(5, 1));
        System.out.println(ab.createString(3, 2));
        System.out.println(ab.createString(2, 0));
        System.out.println(ab.createString(5, 8));
        System.out.println(ab.createString(10, 12));
        System.out.println(ab.createString(10, 9));
        System.out.println(ab.createString(10, 24));

        for (int i = 0; i < 11 * 11 / 2; i++) {
            System.out.printf("11 %d => %s\n", i, ab.createString(11, i));
        }
    }

    public String createString(int n, int K) {
        int b = n / 2;
        int a = n - b;
        if (a * b < K) {
            return "";
        }

        b = binarySearch(n / 2, i ->
                (n - i) * i >= K
        );


        if ((n - b) * b > K) {
            b--;
        }
        a = n - b;
        byte[] res = new byte[n];
        for (int i = 0; i < n; i++) {
            if (i < a) {
                res[i] = 'A';
            } else {
                res[i] = 'B';
            }
        }

        if (a * b < K) {
            int k = (a - 1) * b;
            int i = K - k;
            res[i] = 'B';
        }
        return new String(res);
    }

    private int binarySearch(int n, Predicate<Integer> fn) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (fn.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

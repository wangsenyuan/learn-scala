package p204.countprimes;

import java.util.BitSet;

/**
 * Created by senyuanwang on 15/4/27.
 */
public class Solution {
    public int countPrimes(int n) {
        BitSet bs = new BitSet(n);
        bs.set(0);
        bs.set(1);
        int ind = 0, count = 0;
        while (ind < n) {
            ind = bs.nextClearBit(ind + 1);
            if (ind >= n)
                return count;
            count++;
            for (int i = 2 * ind; i < n; i += ind)
                bs.set(i);
        }
        return count;
    }

    public int countPrimes1(int n) {
        if (n < 3) {
            return 0;
        }

        boolean[] nonPrimes = new boolean[n];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        int count = n - 2;
        for (int p = 2; p * p < n; ) {
            for (int i = 2; i * p < n; i++) {
                if (!nonPrimes[i * p]) {
                    count--;
                }
                nonPrimes[i * p] = true;
            }

            int j = p + 1;
            while (j * j < n) {
                if (!nonPrimes[j]) {
                    break;
                }
                j++;
            }
            p = j;
        }

        return count;
    }
}

package problems.simple.p354;

import java.util.BitSet;
import java.util.Calendar;

/**
 * Created by senyuanwang on 15/5/5.
 */
public class Main {

    private static final int MAX_N = 19900101;

    public static void main(String[] args) {
        BitSet primes = primes(MAX_N);

        Calendar start = Calendar.getInstance();
        start.set(Calendar.YEAR, 1987);
        start.set(Calendar.MONTH, Calendar.DECEMBER);
        start.set(Calendar.DAY_OF_MONTH, 31);

        Calendar end = Calendar.getInstance();
        end.set(Calendar.YEAR, 1990);
        end.set(Calendar.MONTH, Calendar.JANUARY);
        end.set(Calendar.DAY_OF_MONTH, 0);

        for (int i = 0; i <= 2 * 365; i++) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            if(start.compareTo(end) >= 0) {
                break;
            }
            int year = start.get(Calendar.YEAR) * 10000;
            int month = (start.get(Calendar.MONTH) + 1) * 100;
            int day = start.get(Calendar.DAY_OF_MONTH);
            int date = year + month + day;
            if(!primes.get(date)) {
                System.out.println(date);
            }
        }
    }


    private static BitSet primes(int maxN) {

        BitSet bitSet = new BitSet(maxN);
        bitSet.set(0);
        bitSet.set(1);

        int i = 1;

        while (i < maxN) {
            i = bitSet.nextClearBit(i + 1);

            for (int j = 2 * i; j < maxN; j += i) {
                bitSet.set(j);
            }
        }

        return bitSet;
    }
}

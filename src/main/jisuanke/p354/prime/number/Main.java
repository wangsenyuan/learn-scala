package p354.prime.number;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by senyuanwang on 16/5/7.
 */
public class Main {

    public static void main(String[] args) {
        /*List<Integer> primes = fillPrimeNumber2(19891231);
        for (int x : primes) {
            if (x < 19880101) {
                continue;
            }
            System.out.println(x);
        }*/
        printPrimes(19880101, 19891231);
    }

    private static List<Integer> fillPrimeNumbers1(int maxNum) {
        BigInteger num = new BigInteger("2");
        List<Integer> primes = new ArrayList<>();
        primes.add(num.intValue());
        while (num.intValue() < maxNum) {
            num = num.nextProbablePrime();
            primes.add(num.intValue());
        }
        return primes;
    }

    private static List<Integer> fillPrimeNumber2(int maxNum) {
        BitSet bs = new BitSet();
        List<Integer> primes = new ArrayList<>();

        int x = 2;
        primes.add(x);
        for (; x < maxNum; ) {
            for (int i = 2; i * x <= maxNum; i++) {
                bs.set(i * x);
            }
            x = bs.nextClearBit(x + 1);
            primes.add(x);
        }

        return primes;
    }

    private static void printPrimes(int start, int end) {
        BitSet bs = new BitSet();

        for (int x = 2; x <= end; ) {
            for (int i = 2; i * x <= end; i++) {
                bs.set(i * x);
            }
            x = bs.nextClearBit(x + 1);
            if (x >= start && validDate(x)) {
                System.out.println(x);
            }
        }
    }

    private static DateFormat df = new SimpleDateFormat("yyyyMMdd");

    private static boolean validDate(int x) {
        String s = "" + x;
        try {
            return s.equals(df.format(df.parse(s)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

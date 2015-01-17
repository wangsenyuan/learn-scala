package problems.simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by senyuanwang on 14/11/20.
 */
public class PrimeCheck {
    private static int[] primes = primes(1000);

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if(primes[n] == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int[] primes(int max) {
        int[] array = new int[max + 1];

        Arrays.fill(array, 1);
        array[0] = 0;
        array[1] = 0;
        array[2] = 1;

        for(int i = 2; i <= max; i++) {
            if(array[i] == 0) {
                continue;
            }
            for(int k = 2; k * i <= max; k++) {
                array[k * i] = 0;
            }
        }
        return array;
    }
}

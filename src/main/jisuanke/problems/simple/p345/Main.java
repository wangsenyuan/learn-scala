package problems.simple.p345;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        List<Integer> factors = primeFactors(x);
        for (int i = 0; i < factors.size(); i++) {
            int a = factors.get(i);
            System.out.print(String.format("%d%s", a, i == factors.size() - 1 ? "" : " "));
        }
    }

    public static List<Integer> primeFactors(int x) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= x; ) {
            if (isPrime(i) && x % i == 0) {
                factors.add(i);
                x = x / i;
            } else {
                i += 1;
            }
        }

        return factors;
    }

    private static boolean isPrime(int x) {
        int y = (int) Math.sqrt(x);

        for (int i = 2; i <= y; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

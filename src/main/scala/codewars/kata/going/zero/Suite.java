package codewars.kata.going.zero;

public class Suite {

    public static double going(int n) {
        double res = 1.0d;

        for (int i = 2; i <= n; i++) {
            res = 1.0d + res / i;
        }

        long tmp = (long) (res * 1000000);
        res = (double) tmp / 1000000;

        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%d => %.10f", i, going(i)));
        }
    }
}

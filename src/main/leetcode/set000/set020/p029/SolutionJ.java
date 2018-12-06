package set000.set020.p029;

/**
 * Created by senyuanwang on 16/7/3.
 */
public class SolutionJ {

    public static int divide(int dividend, int divisor) {
        long dvd = dividend;
        long dvs = divisor;

        boolean positive = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        if (dividend < 0) {
            dvd *= -1;
        }
        if (divisor < 0) {
            dvs *= -1;
        }
        long res = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            long times = 1;
            while (dvd >= (temp << 1)) {
                temp = temp << 1;
                times = times << 1;
            }
            res += times;
            dvd -= temp;
        }

        if (!positive) {
            res = -1 * res;
        }

        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}

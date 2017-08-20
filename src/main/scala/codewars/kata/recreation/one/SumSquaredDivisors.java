package codewars.kata.recreation.one;

public class SumSquaredDivisors {
    private static String squareSum(long x) {
        long sum = 0;
        long sq = (long) Math.sqrt(x);
        for (int a = 1; a <= sq; a++) {
            if (x % a == 0) {
                sum += a * a;
                long b = x / a;
                if (b != a) {
                    sum += b * b;
                }
            }
        }

        long sr = (long) Math.sqrt(sum);
        if (sr * sr == sum) {
            return String.format("[%d, %d]", x, sum);
        }
        return "";
    }

    public static String listSquared(long m, long n) {
        StringBuilder sb = new StringBuilder();

        long x = m;
        while (x <= n) {
            String str = squareSum(x);
            if (!str.isEmpty()) {
                sb.append(str);
                sb.append(", ");
            }
            x += 1;
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return "[" + sb.toString() + "]";
    }

    public static void main(String[] args) {
        System.out.println(listSquared(1, 250));
        System.out.println(listSquared(42, 250));
        System.out.println(listSquared(250, 500));
        System.out.println(listSquared(300, 600));

    }
}

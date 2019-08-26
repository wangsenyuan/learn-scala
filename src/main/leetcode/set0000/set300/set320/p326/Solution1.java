package set0000.set300.set320.p326;

/**
 * Created by wangsenyuan on 1/8/16.
 */
public class Solution1 {

    static int powerThree(int x) {
        return x * x * x;
    }

    static int[] BASE_NUMS = new int[9];

    static {
        for (int i = 1; i <= 9; i++) {
            BASE_NUMS[i - 1] = powerThree(i);
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0 || n % 10 == 0) {
            return false;
        }

        for (int x : BASE_NUMS) {
            if (x == n) {
                return true;
            }
        }

        int lastDigit = n % 10;

        if (lastDigit == 1) {
            return isPowerOfThree(n / 10);
        } else if (lastDigit == 2) {
            return isPowerOfThree(n / 10 - 51);
        } else if (lastDigit == 3) {
            return isPowerOfThree(n / 10 - 34);
        } else if (lastDigit == 4) {
            return isPowerOfThree(n / 10 - 6);
        } else if (lastDigit == 5) {
            return isPowerOfThree(n / 10 - 12);
        } else if (lastDigit == 6) {
            return isPowerOfThree(n / 10 - 21);
        } else if (lastDigit == 7) {
            return isPowerOfThree(n / 10 - 2);
        } else if (lastDigit == 8) {
            return isPowerOfThree(n / 10);
        } else {
            return isPowerOfThree(n / 10 - 72);
        }
    }

    public boolean isPowerOfThreeCorrect(int n) {
        if (n % 10 == 0) {
            return false;
        }

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (powerThree(i) == n) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThree3(int n) {
        double error = 0.0000000001;
        return ((Math.log(n) / Math.log(3)) + error) % 1 <= 2 * error;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        for (int i = 1; i < 30000; i++) {
            if (solution1.isPowerOfThree(i) != solution1.isPowerOfThreeCorrect(i)) {
                System.out.println(i + " not correct");
            }
        }
    }
}

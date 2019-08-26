package set0000.set300.set370.p374;

/**
 * Created by wangsenyuan on 7/13/16.
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        while (i <= j) {
            int k = i + (j - i) / 2;
            int r = guess(k);
            if (r == 0) {
                return k;
            }

            if (r > 0) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }

        return i;
    }

    private int guess(int k) {
        return 6 - k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}

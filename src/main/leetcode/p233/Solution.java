package p233;

/**
 * Created by wangsenyuan on 9/20/16.
 */
public class Solution {

    public static int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1)
                ans += n % x + 1;
            if (digit > 1)
                ans += x;
            x *= 10;
        } while (q > 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(1000));
        System.out.println(countDigitOne(2000));

    }
}

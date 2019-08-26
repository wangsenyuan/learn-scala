package set0000.set300.set300.p309;

/**
 * Created by wangsenyuan on 26/10/2016.
 */
public class Solution1 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit1 = 0, profit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int copy = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
            profit2 = Math.max(copy, profit2);
        }
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}

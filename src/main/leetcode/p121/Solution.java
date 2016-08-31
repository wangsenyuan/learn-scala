package p121;

/**
 * Created by wangsenyuan on 8/16/16.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int i = 0;
        int profit = 0;
        for (int j = 0; j < n; j++) {
            int price = prices[j];
            while (i > 0 && price < stack[i - 1]) {
                profit = Math.max(profit, stack[i - 1] - stack[0]);
                i--;
            }
            stack[i++] = price;
        }
        if (i > 0) {
            profit = Math.max(profit, stack[i - 1] - stack[0]);
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (buy < -price) {
                buy = -price;
            }
            if (sell < buy + price) {
                sell = buy + price;
            }
        }
        return sell;
    }
}

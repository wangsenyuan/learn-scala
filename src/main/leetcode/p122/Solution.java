package p122;

/**
 * Created by wangsenyuan on 8/16/16.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; ) {
            int price = prices[i];
            int j = i;
            while (j < prices.length - 1 && prices[j + 1] >= prices[j]) {
                j++;
            }

            if (j > i) {
                profit += prices[j] - price;
                i = j + 1;
            } else {
                i++;
            }
        }

        return profit;
    }
}

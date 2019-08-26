package set0000.set100.set180.p188;

/**
 * Created by senyuanwang on 16/9/4.
 */
public class Solution2 {

    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }

        int[] profits = new int[2 * k];

        for (int i = 0; i < k; i++) {
            profits[2 * i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (-price > profits[0]) {
                profits[0] = -price;
            }
            if (profits[0] + price > profits[1]) {
                profits[1] = profits[0] + price;
            }

            for (int j = 1; j < k; j++) {
                if (profits[2 * j - 1] - price > profits[2 * j]) {
                    profits[2 * j] = profits[2 * j - 1] - price;
                }

                if (profits[2 * j] + price > profits[2 * j + 1]) {
                    profits[2 * j + 1] = profits[2 * j] + price;
                }
            }
        }


        return profits[2 * k - 1];
    }
}

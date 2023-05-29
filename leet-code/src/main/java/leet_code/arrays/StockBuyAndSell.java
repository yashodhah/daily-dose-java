package leet_code.arrays;

public class StockBuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int buy = prices[0];
        int max_profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
                continue;
            }

            int profit = prices[i] - buy;

            if (profit > max_profit) {
                max_profit = profit;
            }
        }

        System.out.println(max_profit);
        return max_profit;
    }

    public static void main(String[] args) {
        StockBuyAndSell stockBuyAndSells = new StockBuyAndSell();

        stockBuyAndSells.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        stockBuyAndSells.maxProfit(new int[]{7, 6, 4, 3, 1});
    }
}

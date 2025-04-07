public class BestTimeToSellStocks {

    public static void main(String[] args) {
        int[] prices = { 7, 3, 2, 4, 8, 10, 6, 5 };
        System.out.println("max profit by single transaction: " + maxProfitSingleTransaction(prices));
        System.out.println("total profit from multiple transactions: " + totalProfitMultipleTransactions(prices));

    }

    /**
     * Calculate the max profit possible by buying low and selling high (one
     * transaction)
     */

    public static int maxProfitSingleTransaction(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // min price
            if (prices[i] < minPrice)
                minPrice = prices[i];

            int profit = prices[i] - minPrice;
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    /**
     * Calculate the total profit by buying low, selling high (multiple
     * transactions)
     */

    public static int totalProfitMultipleTransactions(int[] prices) {
        int profit = 0;
        // we start at the second day so we can compare to prior
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

}

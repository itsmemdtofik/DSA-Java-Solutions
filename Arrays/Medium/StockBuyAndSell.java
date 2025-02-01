package Medium;

/**
 * ! Stock Buy and Sell - Multiple transaction is allowed.
 * 
 * Given an array prices[] of size n denoting the cost of stock on each day, the
 * task is to find the maximum total profit if we can buy and sell the stocks
 * any number of times.
 * 
 * Note: We can only sell a stock which we have bought earlier and we cannot
 * hold multiple stocks on any day.
 * 
 * Input: prices[] = {100, 180, 260, 310, 40, 535, 695}
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
 * Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
 * Maximum Profit = 210 + 655 = 865
 * 
 * Input: prices[] = {4, 2, 2, 2, 4}
 * Output: 2
 * Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2
 * Maximum Profit = 2
 */
public class StockBuyAndSell {

    /**
     * * Approach:
     * If the price increases from one day to the next, it means you can make a
     * profit by buying on the first day and selling on the next. So, you add that
     * difference to the total profit.
     * 
     * You don't need to worry about holding the stock for more than one day because
     * you're allowed to sell and buy on subsequent days as long as it’s profitable.
     * 
     * @param stockBuyAndSell
     * @return maxProfit
     */
    public static int stockBuyAndSell(int arr[]) {

        if (arr.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                maxProfit += arr[i] - arr[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        // Example prices array
        int[] prices = { 100, 180, 260, 310, 40, 535, 695 };

        // Calculate the maximum profit
        int profit = stockBuyAndSell(prices);

        // Output the result
        System.out.println("Maximum Profit: " + profit);

        // Example prices array
        int[] prices1 = { 4, 2, 2, 2, 4 };

        // Calculate the maximum profit
        int profit1 = stockBuyAndSell(prices1);

        // Output the result
        System.out.println("Maximum Profit: " + profit1);
    }
}

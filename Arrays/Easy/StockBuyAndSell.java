package Easy;

/**
 * * Stock Buy and Sell – Max one Transaction Allowed.
 * 
 * Given an array prices[] of length N, representing the prices of the stocks on
 * different days, the task is to find the maximum profit possible by buying and
 * selling the stocks on different days when at most one transaction is allowed.
 * Here one transaction means 1 buy + 1 Sell.
 * 
 * Note: Stock must be bought before being sold.
 * 
 * Examples:
 * 
 * Input: prices[] = {7, 10, 1, 3, 6, 9, 2}
 * Output: 8
 * Explanation: Buy for price 1 and sell for price 9.
 * 
 * 
 * Input: prices[] = {7, 6, 4, 3, 1}
 * Output: 0
 * Explanation: Since the array is sorted in decreasing order, 0 profit can be
 * made without making any transaction.
 * 
 * Input: prices[] = {1, 3, 6, 9, 11}
 * Output: 10
 * Explanation: Since the array is sorted in increasing order, we can make
 * maximum profit by buying at price[0] and selling at price[n-1]
 * 
 */
public class StockBuyAndSell {

    public static int stockBuyAndSell(int prices[]){

        if(prices == null || prices.length == 0 || prices.length < 2){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            if(price < minPrice){
                minPrice = price;
            }

            int profit = price - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static int anotherApproach(int prices[]){
        if(prices == null || prices.length < 2){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
    public static void main(String[] args) {

         // Test cases
         int[] prices1 = {7, 1, 5, 3, 6, 4};  // Expected output: 5
         int[] prices2 = {7, 6, 4, 3, 1};     // Expected output: 0
         int[] prices3 = {1, 2, 1,3, 4, 5};     // Expected output: 4
         int[] prices4 = {10, 22, 5, 75, 65, 80};  // Expected output: 75
 
         System.out.println("Max Profit for prices1: " + stockBuyAndSell(prices1));  // 5
         System.out.println("Max Profit for prices2: " + stockBuyAndSell(prices2));  // 0
         System.out.println("Max Profit for prices3: " + stockBuyAndSell(prices3));  // 4
         System.out.println("Max Profit for prices4: " + stockBuyAndSell(prices4));

         System.out.println("Max Profit for prices1: " + anotherApproach(prices1));  // 5
         System.out.println("Max Profit for prices2: " + anotherApproach(prices2));  // 0
         System.out.println("Max Profit for prices3: " + anotherApproach(prices3));  // 4
         System.out.println("Max Profit for prices4: " + anotherApproach(prices4));

    }
}

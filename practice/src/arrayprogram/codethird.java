/*You are given an array of prices where prices[i] is the price of a given stock on an ith day.You want to maximise your profit by choosing a
single day to buy one stock and choosing a different day in the future  to sell that stock.Return the maximum profit you can achieve from this 
transaction.If you cannot achieve any profit, return 0.*/

package arrayprogram;

public class codethird {
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int price : prices) {
			// Track the minimum price seen so far
			if(price < minPrice) {
				minPrice = price;
			}
			// Calculate profit if selling today
			else if(price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}
		
		return maxProfit;
	}
	
	// Optional main method for testing
	public static void main(String[] args) {
		codethird sp = new codethird();
		int[] prices = {7, 1, 5, 3, 6, 4};
		int result = sp.maxProfit(prices);
		System.out.println("Maximum Profit: " + result);
	}
}

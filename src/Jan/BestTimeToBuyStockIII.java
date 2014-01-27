package Jan;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyStockIII {
	public static void main(String args[]){
		int prices[]={3,3,5,0,0,3,1,4};
		System.out.println(new BestTimeToBuyStockIII().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		boolean bought = false;
		// buy the first one, n.val<n.next.val
		// sell at n.val>n.next.val
		for (int i = 0; i < prices.length; i++) {
			// ? to buy
			if (i == prices.length - 1) {
				if (bought == true) {
					// sell
					profit += prices[i];
					bought = false;
					System.out.println("Sell: "+prices[i]);
				}
				continue;
			}
			if (prices[i] < prices[i + 1]) {
				// buy
				if (bought == false) {
					profit -= prices[i];
					bought = true;
					System.out.println("Buy: "+prices[i]);
				}
				continue;
			}
			if (prices[i] > prices[i + 1]) {
				// sell
				if (bought == true) {
					profit += prices[i];
					bought = false;
					System.out.println("Sell: "+prices[i]);
				}
			}
		}
		return profit;
	}
}

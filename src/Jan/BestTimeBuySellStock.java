package Jan;

public class BestTimeBuySellStock {

	public int maxProfit(int[] prices) {
		int result = 0;
		int min = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[min] > prices[i]) {
				min = i;
			}
			int diff = prices[i] - prices[min];
			if (diff > result) {
				result = diff;
			}
		}
		return result;
	}
}

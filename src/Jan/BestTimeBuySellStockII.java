package Jan;

public class BestTimeBuySellStockII {

	

	public int maxProfit(int[] prices) {
        int profit=0;
        boolean bought=false;
        @SuppressWarnings("unused")
		int previous = 0;
        int index=0;
        while(index<prices.length){
            if(bought==false){
                //bought the next smallest one
                if(index==prices.length-1){
                    break;
                }
                int current=prices[index];
                int next=prices[index+1];
                if(current<next){
                    //buy current
                    previous=current;
                    profit-=current;
                    bought=true;
                }
            }else{
                //sell the next most expensive one
                int current=prices[index];
                if(index==prices.length-1){
                    //sell the last one
                    profit+=current;
                    bought=false;
                    break;
                }
                int next=prices[index+1];
                if(current>next){
                    //sell current
                    bought=false;
                    profit+=current;
                }
            }
            index++;
        }
        return profit;
    }
}

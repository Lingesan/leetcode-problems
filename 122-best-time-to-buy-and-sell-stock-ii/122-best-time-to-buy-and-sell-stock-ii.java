class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0, sellDay = 1, maxProfit = 0;
        while(sellDay < prices.length){
            if(prices[sellDay] > prices[buyDay]){
                maxProfit += prices[sellDay] - prices[buyDay];
                buyDay++;
            } else {
                buyDay = sellDay;
            }
            sellDay++;
        }
        return maxProfit;
    }
}
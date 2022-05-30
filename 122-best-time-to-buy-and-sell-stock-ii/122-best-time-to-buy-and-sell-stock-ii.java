class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0, sellDay = 1, maxProfit = 0;
        while(sellDay < prices.length){
            int profit = prices[sellDay] - prices[buyDay];
            if(profit > 0){
                maxProfit += profit;
                buyDay++;
            } else {
                buyDay = sellDay;
            }
            sellDay++;
        }
        return maxProfit;
    }
}
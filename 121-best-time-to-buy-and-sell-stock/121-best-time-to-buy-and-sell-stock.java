class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = start + 1, maxProfit = 0;
        while(end < prices.length){
            int profit = prices[end] - prices[start];
            if( profit > 0){
                maxProfit = Math.max(profit, maxProfit);
            } else {
                start = end;
            }
            end++;
        }
        return maxProfit;
    }
}
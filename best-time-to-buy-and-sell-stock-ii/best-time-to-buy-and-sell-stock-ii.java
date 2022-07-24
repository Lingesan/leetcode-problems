class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int sellIndex = prices.length - 1;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[sellIndex] >= prices[i]) {
                totalProfit += prices[sellIndex] - prices[i];
            }
            sellIndex = i;
        }
        return totalProfit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int min = 100;
        int b = 0;
        int max = 0;
        while (b < prices.length) {
            if (prices[b] < min) {
                min = prices[b];
            }
            if (prices[b] - min > max) {
                max = prices[b] - min;
            }
            b++;
        }
        return max;
    }
}

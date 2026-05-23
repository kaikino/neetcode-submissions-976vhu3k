class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [0] * len(prices)
        # buy, sell, hold sold
        dp[0] = [-prices[0], 0, 0]
        for i in range(1, len(prices)):
            # buy = max(buy, hold sold - price)
            # sell = buy + price
            # hold sold = max(sell, hold sold)
            dp[i] = [max(dp[i-1][0], dp[i-1][2]-prices[i]),
                     dp[i-1][0] + prices[i],
                     max(dp[i-1][1], dp[i-1][2])]
        return max(dp[-1][1], dp[-1][2])
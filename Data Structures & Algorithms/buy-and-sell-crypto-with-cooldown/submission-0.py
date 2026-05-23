class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [0] * len(prices)
        # buy, sell, hold buy, hold sold
        dp[0] = [-prices[0], 0, -10000, 0]
        for i in range(1, len(prices)):
            # buy = hold sold - price
            # sell = max(buy + price, hold buy + price)
            # hold buy = max(buy, hold buy)
            # hold sold = max(sell, hold sold)
            dp[i] = [dp[i-1][3]-prices[i],
                     max(dp[i-1][0], dp[i-1][2]) + prices[i],
                     max(dp[i-1][0], dp[i-1][2]),
                     max(dp[i-1][1], dp[i-1][3])]
        return max(dp[-1][1], dp[-1][3])
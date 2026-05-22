class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        dp = {h: 0 for h in heights}
        out = heights[0]
        for i in dp:
            if (i > heights[0]):
                continue
            dp[i] = 1

        for h, height in enumerate(heights[1:], start=1):
            for i in dp:
                if (i > height):
                    dp[i] = 0
                else:
                    dp[i] = dp[i] + 1
                    out = max(out, i * dp[i])

        return out



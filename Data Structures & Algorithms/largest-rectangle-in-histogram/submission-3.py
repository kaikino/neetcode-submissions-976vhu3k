class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        dp = list(dict() for x in range(0, len(heights)))
        keys = set()
        for h in heights:
            keys.add(h-1)
        out = heights[0]
        for i in range(0, heights[0]):
            dp[0][i] = 1
        for h, height in enumerate(heights[1:], start=1):
            for i in range(0, height):
                if i not in keys:
                    continue
                if i in dp[h-1]:
                    dp[h][i] = dp[h-1][i] + 1
                else:
                    dp[h][i] = 1
                out = max(out, (i+1) * dp[h][i])

        return out



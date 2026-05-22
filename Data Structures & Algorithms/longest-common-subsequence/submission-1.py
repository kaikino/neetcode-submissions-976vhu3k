class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[0 for _ in range(0, len(text2) + 1)] for _ in range(0, len(text1) + 1)]
        for i in range(len(dp) - 2, -1, -1):
            for j in range(len(dp[0]) - 2, -1, -1):
                val = max(dp[i+1][j], dp[i][j+1])
                if text1[i] == text2[j]:
                    val = max(val, dp[i+1][j+1] + 1)
                dp[i][j] = val
        return dp[0][0]
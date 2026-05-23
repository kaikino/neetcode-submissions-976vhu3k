class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = [[1 if j == len(p) and i == len(s) else 0 for j in range(len(p) + 1)] for i in range(len(s) + 1)]
        for i in range(len(dp) - 2, -1, -1):
            for j in range(len(dp[0]) - 2, -1, -1):
                # see if we can keep expanding *
                if (dp[i+1][j] == 3):
                    if (p[j] == '.' or p[j] == s[i]):
                        dp[i][j] = 3
                        continue
                # see if we can match or try to match the same char again
                if dp[i+1][j+1] % 2 == 1 or dp[i][j+1] > 1:
                    if (p[j] == '*'):
                        if (p[j-1] == '.' or p[j-1] == s[i]):
                            dp[i][j-1] = 3
                            continue
                        # couldn't match * but we can skip it and attempt the next pattern
                        else:
                            dp[i][j-1] = 2
                        j -= 1
                    elif (p[j] == '.' or p[j] == s[i]):
                        dp[i][j] = 1
                # if string is fully matched, only * can be skipped
                if i == 0 and p[j] == '*' and dp[0][j+1] % 2 == 1:
                    dp[i][j-1] = 1
                    j -= 1
        return dp[0][0] > 0


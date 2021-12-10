class Solution:
    def numTilings(self, n: int) -> int:
        mod = 1000000007
        # this is a dp problem with overlapping subpatterns
        # just need to identify the pattern for a few starting
        # cases and use them to calculate further
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n == 3:
            return 5
        dp = [0] * n
        dp[0] = 1
        dp[1] = 2
        dp[2] = 5
        for i in range(3, n):
            dp[i] = (dp[i-1] * 2 + dp[i-3]) % mod
        return dp[n-1]

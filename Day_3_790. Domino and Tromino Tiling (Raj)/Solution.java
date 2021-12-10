class Solution {

  public int numTilings(int n) {
    int mod = 1000000007;
    // this is a dp problem with overlapping subpatterns
    // just need to identify the pattern for a few starting
    // cases and use them to calculate further
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 5;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    dp[2] = 5;
    for (int i = 3; i < n; i++) {
      dp[i] = (int) (((long) dp[i - 1] * 2 + (long) dp[i - 3]) % mod);
    }
    return dp[n - 1];
  }
}

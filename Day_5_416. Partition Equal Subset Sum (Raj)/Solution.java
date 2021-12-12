class Solution {

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) sum += nums[i];
    // if sum is odd, then array is obviously not
    // divisible into two equal parts
    if (sum % 2 == 1) return false;
    // take the half of sum, and find if sum of any subset
    // equals to this
    int half = sum / 2;
    // array for memoization
    Boolean[][] memo = new Boolean[nums.length][half + 1];
    // helper function for dfs
    return helper(nums, 0, half, memo);
  }

  private boolean helper(int[] nums, int ind, int total, Boolean[][] memo) {
    // solution found
    if (total == 0) return true;
    // solution not found
    if (ind == nums.length) return false;
    if (memo[ind][total] != null) return memo[ind][total];
    // skip this number when taking the sum
    boolean res = helper(nums, ind + 1, total, memo);
    if (nums[ind] <= total) {
      // include this number when taking the sum
      res = res || helper(nums, ind + 1, total - nums[ind], memo);
    }
    return memo[ind][total] = res;
  }
}

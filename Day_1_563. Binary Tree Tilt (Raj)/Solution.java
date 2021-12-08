class Solution {

  // global variable for storing result
  private int res;

  public int findTilt(TreeNode root) {
    res = 0;
    // helper function to get solution
    childSum(root);
    return res;
  }

  private int childSum(TreeNode root) {
    if (root == null) return 0;
    // get left and right subtree sums
    int leftSum = childSum(root.left);
    int rightSum = childSum(root.right);
    // calculate tilt and add to result
    res += Math.abs(leftSum - rightSum);
    return leftSum + rightSum + root.val;
  }
}

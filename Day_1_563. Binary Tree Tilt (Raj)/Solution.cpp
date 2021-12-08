class Solution
{
  // global variable for storing result
  int res;
  int childSum(TreeNode *root)
  {
    if (!root)
      return 0;
    // get left and right subtree sums
    int leftSum = childSum(root->left);
    int rightSum = childSum(root->right);
    // calculate tilt and add to result
    res += abs(leftSum - rightSum);
    return leftSum + rightSum + root->val;
  }

public:
  int findTilt(TreeNode *root)
  {
    res = 0;
    // helper function to get solution
    childSum(root);
    return res;
  }
};
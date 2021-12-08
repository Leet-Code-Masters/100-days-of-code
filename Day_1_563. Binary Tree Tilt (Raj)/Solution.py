class Solution:
    def childSum(self, root) -> int:
        if root == None:
            return 0
        # get left and right subtree sums
        leftSum = self.childSum(root.left)
        rightSum = self.childSum(root.right)
        # calculate tilt and add to result
        self.res += abs(leftSum - rightSum)
        return leftSum + rightSum + root.val

    def findTilt(self, root) -> int:
        self.res = 0
        # helper function to get solution
        self.childSum(root)
        return self.res

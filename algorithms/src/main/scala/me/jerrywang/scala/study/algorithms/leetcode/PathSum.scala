package me.jerrywang.scala.study.algorithms.leetcode

// LC 112
object PathSum {

  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if (root == null)
      return false

    if (root.value == sum && root.left == null && root.right == null)
      return true

    hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
  }
}

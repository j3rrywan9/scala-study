package me.jerrywang.scala.study.algorithms.leetcode.binarytree

import org.scalatest.funsuite.AnyFunSuite

class PathSumTest extends AnyFunSuite {

  test("testExample1") {
    val root = TreeNode(5)

    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.right.right = TreeNode(1)

    assert(PathSum.hasPathSum(root, 22))
  }
}

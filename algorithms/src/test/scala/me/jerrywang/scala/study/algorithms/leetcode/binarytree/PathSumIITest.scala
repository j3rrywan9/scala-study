package me.jerrywang.scala.study.algorithms.leetcode.binarytree

import org.scalatest.funsuite.AnyFunSuite

class PathSumIITest extends AnyFunSuite {

  test("testExample1") {
    val root = TreeNode(5)

    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.right.left = TreeNode(5)
    root.right.right.right = TreeNode(1)

    assert(PathSumII.pathSum(root, 22) == List(List(5, 4, 11, 2), List(5, 8, 4, 5)))
  }
}

package me.jerrywang.scala.study.algorithms.leetcode.binarytree

import org.scalatest.funsuite.AnyFunSuite

class BinaryTreeInorderTraversalTest extends AnyFunSuite {

  test("testExample1") {
    val root = TreeNode(1)

    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    assert(BinaryTreeInorderTraversal.inorderTraversal(root) == List(1, 3, 2))
  }
}

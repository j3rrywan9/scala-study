package me.jerrywang.scala.study.algorithms.leetcode.binarytree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

// LC 94
object BinaryTreeInorderTraversal {

  def inorderTraversal(root: TreeNode): List[Int] = {
    val result = ListBuffer.empty[Int]
    val stack = mutable.Stack.empty[TreeNode]
    var current = root

    while (current != null || stack.nonEmpty) {
      while (current != null) {
        stack.push(current)
        current = current.left
      }

      current = stack.pop()
      result.append(current.value)
      current = current.right
    }

    result.toList
  }
}

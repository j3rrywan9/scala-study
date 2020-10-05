package me.jerrywang.scala.study.algorithms.leetcode.binarytree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

// LC 102
object BinaryTreeLevelOrderTraversal {

  def levelOrder(root: TreeNode): List[List[Int]] = {
    val levels = ListBuffer.empty[List[Int]]

    if (root == null) return levels.toList

    val queue = mutable.Queue.empty[TreeNode]

    queue.append(root)

    var level = 0

    while (queue.nonEmpty) {
      levels.append(List.empty)

      val levelLength = queue.size

      for (_ <- 0 until levelLength) {
        val node = queue.remove(1)

        levels(level).::(node.value)

        if (node.left != null)
          queue.append(node.left)
        if (node.right != null)
          queue.append(node.right)
      }
      level += 1
    }

    levels.toList
  }
}

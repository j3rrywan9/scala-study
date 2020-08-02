package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable.ListBuffer

// LC 113
object PathSumII {

  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    val allPaths = ListBuffer.empty[List[Int]]
    val currentPath = ListBuffer.empty[Int]

    findPathsRecursively(root, sum, currentPath, allPaths)

    allPaths.toList
  }

  private def findPathsRecursively(currentNode: TreeNode, sum: Int, currentPath: ListBuffer[Int],
                                   allPaths: ListBuffer[List[Int]]): Unit = {
    if (currentNode == null)
      return

    currentPath.append(currentNode.value)

    if (currentNode.value == sum && currentNode.left == null && currentNode.right == null) {
      allPaths.appendAll(List(currentPath.toList))
    } else {
      findPathsRecursively(currentNode.left, sum - currentNode.value, currentPath, allPaths)
      findPathsRecursively(currentNode.right, sum - currentNode.value, currentPath, allPaths)
    }

    currentPath.remove(currentPath.length - 1)
  }
}

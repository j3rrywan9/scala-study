package me.jerrywang.scala.study.algorithms.leetcode.binarytree

case class TreeNode(var value: Int, var left: TreeNode, var right: TreeNode) {
  def this(value: Int) = this(value, null, null)
}

object TreeNode {
  def apply(value: Int) = new TreeNode(value)
}

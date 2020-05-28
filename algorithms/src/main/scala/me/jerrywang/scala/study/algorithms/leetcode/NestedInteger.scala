package me.jerrywang.scala.study.algorithms.leetcode

trait NestedInteger {
  def isInteger: Boolean

  def getInteger: Int

  def getList: Seq[NestedInteger]
}

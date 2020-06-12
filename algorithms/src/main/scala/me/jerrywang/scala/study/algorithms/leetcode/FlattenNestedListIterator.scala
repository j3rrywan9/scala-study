package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 341
class FlattenNestedListIterator(nestedList: Seq[NestedInteger]) extends Iterator[Int] {

  private val stack = mutable.ArrayDeque.from(nestedList)

  override def next: Int = {
    if (!hasNext) throw new NoSuchElementException
    stack.removeHead().getInteger
  }

  override def hasNext: Boolean = {
    makeStackTopAnInteger()
    stack.nonEmpty
  }

  private def makeStackTopAnInteger(): Unit = {
    while (stack.nonEmpty && !stack.head.isInteger) {
      val nestedList = stack.removeHead().getList

      for (i <- nestedList.size - 1 to 0 by -1)
        nestedList(i) +=: stack
    }
  }
}

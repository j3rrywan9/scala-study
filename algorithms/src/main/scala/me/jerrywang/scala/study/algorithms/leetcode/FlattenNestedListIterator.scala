package me.jerrywang.scala.study.algorithms.leetcode

class FlattenNestedListIterator(nestedList: Seq[NestedInteger]) extends Iterator[Int] {

  private val integers = Seq.empty[Int]
  private var position = 0

  private def flattenList(nestedList: Seq[NestedInteger]): Unit = {
    for (nestedInteger <- nestedList)
      if (nestedInteger.isInteger) integers.+:(nestedInteger.getInteger)
      else flattenList(nestedInteger.getList)
  }

  flattenList(nestedList)

  override def next: Int = {
    if (!hasNext) throw new NoSuchElementException
    val nextInteger = integers(position)
    position += 1
    nextInteger
  }

  override def hasNext: Boolean = position < integers.size
}

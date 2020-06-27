package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable
import scala.util.Random

// LC 380
class RandomizedSet {

  val map: mutable.Map[Int, Int] = mutable.Map.empty[Int, Int]
  val list: mutable.ListBuffer[Int] = mutable.ListBuffer.empty[Int]
  val rand = new Random()

  def insert(value: Int): Boolean = {
    if (map.contains(value))
      return false

    map.put(value, list.size)
    list.insert(list.size, value)

    true
  }

  def remove(value: Int): Boolean = {
    if (!map.contains(value))
      return false

    val lastElement = list.last
    val index = map(value)

    list.update(index, lastElement)
    map.put(lastElement, index)
    list.remove(list.size - 1)
    map.remove(value)

    true
  }

  def getRandom: Int = list(rand.nextInt(list.size))
}

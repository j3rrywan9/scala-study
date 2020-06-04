package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 451
object SortCharactersByFrequency {

  def frequencySort(s: String): String = {
    val counts = mutable.Map.empty[Char, Int]

    for (c <- s.toCharArray)
      counts.put(c, counts.getOrElse(c, 0) + 1)

    val sortedChars = counts.keySet.toSeq.sortWith((a, b) => counts(a) > counts(b))

    val sb = new mutable.StringBuilder()

    for (c <- sortedChars)
      for (_ <- 0 until counts(c))
        sb.append(c)

    sb.toString()
  }
}

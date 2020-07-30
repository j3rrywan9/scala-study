package me.jerrywang.scala.study.algorithms.leetcode

import scala.math.max
import scala.util.control.Breaks._

// LC 953
object VerifyingAnAlienDictionary {

  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val index = Array.fill[Int](26)(0)

    for (i <- 0 until order.length)
      index(order.charAt(i) - 'a') = i

    breakable(
      for (i <- words.indices) {
        val word1 = words(i)
        val word2 = words(i + 1)

        for (j <- 0 until max(word1.length, word2.length)) {
          if (word1.charAt(j) != word2.charAt(j)) {
            if (index(word1.charAt(j) - 'a') > index(word2.charAt(j) - 'a'))
              return false

            break
          } else {
            if (word1.length > word2.length)
              return false
          }
        }
      }
    )

    true
  }
}

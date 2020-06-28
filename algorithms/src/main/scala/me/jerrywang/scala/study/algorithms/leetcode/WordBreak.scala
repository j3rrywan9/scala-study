package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 139
object WordBreak {

  val memo = mutable.Map.empty[String, Boolean]

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    wordBreak(s, wordDict.toSet)
  }

  def wordBreak(s: String, wordDict: Set[String]): Boolean = {
    // In memo, directly return
    if (memo.contains(s))
      return memo(s)

    // The whole string is a word, memoize and return
    if (wordDict.contains(s)) {
      memo.put(s, true)
      return true
    }

    // Try every break point
    for (i <- 1 until s.length) {
      val left = s.substring(0, i)
      val right = s.substring(i)

      // Find the solution for s, memoize and return
      if (wordBreak(left, wordDict) && wordDict.contains(right)) {
        memo.put(s, true)
        return true
      }
    }

    // No solution for s, memoize and return
    memo.put(s, false)
    false
  }
}

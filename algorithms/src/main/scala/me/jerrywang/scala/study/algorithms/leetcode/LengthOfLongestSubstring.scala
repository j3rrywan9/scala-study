package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable
import scala.math.max

// LC 3
object LengthOfLongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    var length = 0
    // Map character to its index
    val map = mutable.HashMap.empty[Char, Int]
    var i = 0

    for (j <- 0 until s.length) {
      if (map.contains(s.charAt(j))) {
        i = max(map(s.charAt(j)), i)
      }

      length = max(length, j - i + 1)
      map.put(s.charAt(j), j + 1)
    }

    length
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
  }
}

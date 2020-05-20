package me.jerrywang.scala.study.algorithms.leetcode

import scala.math.min

// LC 209
object MinimumSizeSubarraySum {

  def minSubarrayLen(s: Int, nums: Array[Int]): Int = {
    var ans = Int.MaxValue
    var left = 0
    var sum = 0

    for (i <- nums.indices) {
      sum += nums(i)

      while (sum >= s) {
        ans = min(ans, i + 1 - left)
        sum -= nums(left)
        left += 1
      }
    }

    if (ans != Int.MaxValue) ans else 0
  }

  def main(args: Array[String]): Unit = {
    println(minSubarrayLen(7, Array(2, 3, 1, 2, 4, 3)))
  }
}

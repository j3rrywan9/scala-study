package me.jerrywang.scala.study.algorithms.leetcode

// LC 238
object ProductOfArrayExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    val answer = Array.fill[Int](length)(0)

    answer(0) = 1

    for (i <- 1 until length)
      answer(i) = nums(i - 1) * answer(i - 1)

    var R = 1

    for (i <- length - 1 to 0 by -1) {
      answer(i) = answer(i) * R
      R *= nums(i)
    }

    answer
  }
}

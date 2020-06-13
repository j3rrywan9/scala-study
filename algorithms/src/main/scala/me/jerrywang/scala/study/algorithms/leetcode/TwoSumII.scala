package me.jerrywang.scala.study.algorithms.leetcode

// LC 167
object TwoSumII {

  def twoSum(numbers: Array[Int], target: Int): (Int, Int) = {
    var l = 0
    var r = numbers.length - 1

    while (numbers(l) + numbers(r) != target)
      if (numbers(l) + numbers(r) < target) l += 1
      else r -= 1

    (l + 1, r + 1)
  }
}

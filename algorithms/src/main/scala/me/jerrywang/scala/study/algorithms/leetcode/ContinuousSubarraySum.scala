package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 523
object ContinuousSubarraySum {

  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    var sum = 0
    val map = mutable.Map.empty[Int, Int]

    map.put(0, -1)

    for (i <- nums.indices) {
      sum += nums(i)

      if (k != 0)
        sum = sum % k

      if (map.contains(sum)) {
        if (i - map(sum) > 1)
          return true
      } else
        map.put(sum, i)
    }

    false
  }
}

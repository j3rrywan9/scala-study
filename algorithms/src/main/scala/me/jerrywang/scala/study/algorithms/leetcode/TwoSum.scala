package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 1
object TwoSum {

  def twoSum(nums: Array[Int], target: Int): (Int, Int) = {
    val map = mutable.Map.empty[Int, Int]

    for (i <- nums.indices) {
      val complement = target - nums(i)

      if (map.contains(complement))
        return (map(complement), i)
      else
        map.put(nums(i), i)
    }

    throw new IllegalArgumentException("No two sum solution")
  }
}

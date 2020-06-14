package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable
import scala.math.{ max, min }

// LC 15
object ThreeSum {

  def threeSum(nums: Array[Int], target: Int): List[List[Int]] = {
    val res = mutable.ListBuffer.empty[List[Int]]
    val found = mutable.Set.empty[(Int, Int)]

    for (i <- nums.indices) {
      val seen = mutable.Set.empty[Int]

      for (j <- i + 1 until nums.length) {
        val complement = target - nums(i) - nums(j)

        if (seen.contains(complement)) {
          val v1 = min(nums(i),  min(complement, nums(j)))
          val v2 = max(nums(i),  max(complement, nums(j)))

          if (found.add((v1, v2)))
            res.append(List(nums(i), complement, nums(j)))
        }

        seen.add(nums(j))
      }
    }

    res.toList
  }
}

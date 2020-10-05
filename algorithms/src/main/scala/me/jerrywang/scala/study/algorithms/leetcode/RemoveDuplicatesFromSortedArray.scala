package me.jerrywang.scala.study.algorithms.leetcode

// LC 26
object RemoveDuplicatesFromSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length == 0) {
      return 0
    }

    var slow = 0

    for (fast <- 1 until nums.length) {
      if (nums(fast) != nums(slow)) {
        slow += 1
        nums(slow) = nums(fast)
      }
    }

    slow + 1
  }
}

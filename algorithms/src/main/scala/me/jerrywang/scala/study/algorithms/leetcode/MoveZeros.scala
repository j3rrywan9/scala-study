package me.jerrywang.scala.study.algorithms.leetcode

// LC 283
object MoveZeros {

  def moveZeros(nums: Array[Int]): Unit = {
    var anchor = 0

    for (explorer <- nums.indices) {
      if (nums(explorer) != 0) {
        val temp = nums(anchor)
        nums(anchor) = nums(explorer)
        nums(explorer) = temp

        anchor += 1
      }
    }
  }
}

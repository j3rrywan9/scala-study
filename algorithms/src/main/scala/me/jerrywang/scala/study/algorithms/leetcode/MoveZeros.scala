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
        anchor = anchor + 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 1, 0, 3, 12)

    MoveZeros.moveZeros(nums)
    println(s"[${nums.mkString(", ")}]")
  }
}

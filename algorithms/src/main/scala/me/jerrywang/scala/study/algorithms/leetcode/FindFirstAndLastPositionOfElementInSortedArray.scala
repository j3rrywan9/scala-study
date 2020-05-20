package me.jerrywang.scala.study.algorithms.leetcode

// LC 34
object FindFirstAndLastPositionOfElementInSortedArray {

  private def extremeInsertionIndex(nums: Array[Int], target: Int, left: Boolean): Int = {
    var lo = 0
    var hi = nums.length

    while (lo < hi) {
      val mid = lo + (hi - lo) / 2

      if (nums(mid) > target || (left && target == nums(mid))) {
        hi = mid
      } else {
        lo = mid + 1
      }
    }

    lo
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val targetRange = Array.fill[Int](2)(-1)

    val leftIndex = extremeInsertionIndex(nums, target, left = true)

    if (leftIndex == nums.length || nums(leftIndex) != target) {
      return targetRange
    }

    targetRange(0) = leftIndex
    targetRange(1) = extremeInsertionIndex(nums, target, left = false) - 1

    targetRange
  }

  def main(args: Array[String]): Unit = {
    val range = searchRange(Array(5, 7, 7, 8, 8, 10), 8)

    println(range.mkString("[", ", ", "]"))
  }
}

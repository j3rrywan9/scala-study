package me.jerrywang.scala.study.algorithms.leetcode

// LC 33
object SearchInRotatedSortedArray {

  def search(nums: Array[Int], target: Int): Int = {
    var start = 0
    var end = nums.length - 1

    while (start <= end) {
      val mid = start + (end - start) / 2

      if (nums(mid) == target) return mid
      else if (nums(mid) >= nums(start)) {
        if (target >= nums(start) && target < nums(mid)) end = mid - 1
        else start = mid + 1
      } else {
        if (target <= nums(end) && target > nums(mid)) start = mid + 1
        else end = mid - 1
      }
    }

    -1
  }

  def main(args: Array[String]): Unit = {
    println(search(Array(4, 5, 6, 7, 0, 1, 2), 0))
    println(search(Array(4, 5, 6, 7, 0, 1, 2), 3))
  }
}

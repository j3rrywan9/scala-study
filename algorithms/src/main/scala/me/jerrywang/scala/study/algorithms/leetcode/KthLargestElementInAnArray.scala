package me.jerrywang.scala.study.algorithms.leetcode

import scala.annotation.tailrec
import scala.util.Random

// LC 215
object KthLargestElementInAnArray {

  private var nums = Array.emptyIntArray

  private def swap(a: Int, b: Int): Unit = {
    val temp = this.nums(a)
    this.nums(a) = this.nums(b)
    this.nums(b) = temp
  }

  private def partition(left: Int, right: Int, indexOfPivot: Int): Int = {
    val pivot = this.nums(indexOfPivot)

    swap(indexOfPivot, right)

    var storeIndex = left

    // Move all smaller elements to the left
    for (i <- left to right) {
      if (this.nums(i) < pivot) {
        swap(storeIndex, i)
        storeIndex += 1
      }
    }

    swap(storeIndex, right)

    storeIndex
  }

  @tailrec
  private def quickSelect(left: Int, right: Int, kthSmallest: Int): Int = {
    if (left == right) return this.nums(left)

    // Select a random pivot
    var indexOfPivot = left + new Random().nextInt(right - left)

    indexOfPivot = partition(left, right, indexOfPivot)

    if (kthSmallest == indexOfPivot)
      this.nums(kthSmallest)
    else if (kthSmallest < indexOfPivot)
      quickSelect(left, indexOfPivot - 1, kthSmallest)
    else
      quickSelect(indexOfPivot + 1, right, kthSmallest)
  }

  def findKthLargest(nums: Array[Int], k: Int): Int = {
    if (nums == null || nums.length < k ) throw new IllegalArgumentException("Invalid input")

    this.nums = nums
    val size = nums.length

    // k-th largest is (N - k)-th smallest
    quickSelect(0, size - 1, size - k)
  }

  def main(args: Array[String]): Unit = {
    println(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
  }
}

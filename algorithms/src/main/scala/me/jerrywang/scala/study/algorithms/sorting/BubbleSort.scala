package me.jerrywang.scala.study.algorithms.sorting

object BubbleSort {

  def sort(array: Array[Int]): Unit = {
    val n = array.length

    for (i <- 0 until n) {
      var swapped = false

      for (j <- 0 until n - i - 1) {
        if (array(j) > array(j + 1)) {
          val temp = array(j + 1)
          array(j + 1) = array(j)
          array(j) = temp
          swapped = true
        }
      }

      if (!swapped) return
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(64, 34, 25, 12, 22, 11, 90, 42)

    println(s"Original array:")
    println(array mkString " ")

    SelectionSort.sort(array)

    println(s"Sorted array:")
    println(array mkString " ")
  }
}

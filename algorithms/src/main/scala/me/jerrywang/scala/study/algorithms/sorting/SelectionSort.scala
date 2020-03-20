package me.jerrywang.scala.study.algorithms.sorting

object SelectionSort {

  def sort(array: Array[Int]): Unit = {
    val n = array.length

    // We only need to run this loop (array.length - 1) times
    for (i <- 0 until n - 1) {
      var indexOfMinElement = i

      for (j <- i + 1 until n) {
        if (array(j) < array(indexOfMinElement)) {
          indexOfMinElement = j
        }
      }
      // Swap array(i) and minimum element
      val temp = array(i)
      array(i) = array(indexOfMinElement)
      array(indexOfMinElement) = temp
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

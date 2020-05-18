package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable
import scala.math.min

// LC 862
object ShortestSubarrayWithSumAtLeastK {

  def shortestSubarray(A: Array[Int], K: Int): Int = {
    val N = A.length
    val P = Array.fill[Long](N + 1)(0)

    for (i <- 0 until N) {
      P(i + 1) = P(i) + A(i)
    }

    var ans = N + 1
    val monoQueue = mutable.ArrayDeque.empty[Int]

    for (y <- P.indices) {
      while (monoQueue.nonEmpty && P(y) <= P(monoQueue.last))
        monoQueue.removeLast()
      while (monoQueue.nonEmpty && P(y) >= P(monoQueue.head) + K)
        ans = min(ans, y - monoQueue.removeHead())

      monoQueue.append(y)
    }

    if (ans < N + 1) ans else -1
  }

  def main(args: Array[String]): Unit = {
    println(shortestSubarray(Array(1), 1))
    println(shortestSubarray(Array(1, 2), 4))
    println(shortestSubarray(Array(2, -1, 2), 3))
  }
}

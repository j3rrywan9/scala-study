package me.jerrywang.scala.study.algorithms.leetcode

import scala.math.{ min, max }

// LC 621
object TaskScheduler {

  def leastInterval(tasks: Array[Char], n: Int): Int = {
    // frequencies for tasks
    val frequencies = Array.fill[Int](26)(0)

    for (task <- tasks)
      frequencies(task - 'A') += 1

    frequencies.sortInPlace()

    // maximum frequency
    val MaxFrequency = frequencies(25)
    var idleTime = (MaxFrequency - 1) * n

    for (i <- frequencies.length - 2 to 0 by -1 if idleTime > 0)
      idleTime -= min(MaxFrequency - 1, frequencies(i))

    idleTime = max(0, idleTime)

    idleTime + tasks.length
  }
}

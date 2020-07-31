package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class TaskSchedulerTest extends AnyFunSuite {

  test("testExample1") {
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B'), 2) == 8)
  }

  test("testExample2") {
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B'), 0) == 6)
  }

  test("testExample3") {
    assert(TaskScheduler.leastInterval(Array('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2) == 16)
  }
}

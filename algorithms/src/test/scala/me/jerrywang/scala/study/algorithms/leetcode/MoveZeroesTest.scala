package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class MoveZeroesTest extends AnyFunSuite {

  test("testExample1") {
    val nums = Array(0, 1, 0, 3, 12)

    MoveZeros.moveZeros(nums)
    assert(nums sameElements Array(1, 3, 12, 0, 0))
  }
}

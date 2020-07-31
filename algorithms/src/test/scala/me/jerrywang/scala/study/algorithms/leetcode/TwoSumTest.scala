package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class TwoSumTest extends AnyFunSuite {

  test("testExample1") {
    assert(TwoSum.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
  }
}

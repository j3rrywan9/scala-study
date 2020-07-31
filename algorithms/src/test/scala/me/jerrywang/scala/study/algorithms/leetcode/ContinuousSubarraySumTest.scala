package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class ContinuousSubarraySumTest extends AnyFunSuite {

  test("testExample1") {
    assert(ContinuousSubarraySum.checkSubarraySum(Array(23, 2, 4, 6, 7), 6))
  }

  test("testExample2") {
    assert(ContinuousSubarraySum.checkSubarraySum(Array(23, 2, 6, 4, 7), 6))
  }
}

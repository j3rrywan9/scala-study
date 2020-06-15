package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class TwoSumIITest extends FunSuite {

  test("testExample1") {
    assert(TwoSumII.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(1, 2))
  }
}

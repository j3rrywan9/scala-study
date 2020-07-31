package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class ThreeSumTest extends AnyFunSuite {

  test("testExample1") {
    assert(ThreeSum.threeSum(Array(-1, 0, 1, 2, -1, -4), 0) == List(List(-1, 0, 1), List(-1, 2, -1)))
  }
}

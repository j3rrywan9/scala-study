package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class TrappingRainWaterTest extends FunSuite {

  test("testExample") {
    assert(TrappingRainWater.trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
  }
}

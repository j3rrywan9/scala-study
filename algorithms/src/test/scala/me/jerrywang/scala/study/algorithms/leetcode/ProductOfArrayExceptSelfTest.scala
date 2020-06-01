package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class ProductOfArrayExceptSelfTest extends FunSuite {

  test("testExample") {
    assert(ProductOfArrayExceptSelf.productExceptSelf(Array(1, 2, 3, 4)).sameElements(Array(24, 12, 8, 6)))
  }
}

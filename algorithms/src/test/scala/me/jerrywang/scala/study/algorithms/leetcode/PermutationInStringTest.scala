package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class PermutationInStringTest extends AnyFunSuite {

  test("testExample1") {
    assert(PermutationInString.checkInclusion("ab", "eidbaooo"))
  }

  test("testExample2") {
    assert(!PermutationInString.checkInclusion("ab", "eidboaoo"))
  }
}

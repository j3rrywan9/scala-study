package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class PermutationInStringTest extends FunSuite {

  test("testExample1") {
    assert(PermutationInString.checkInclusion("ab", "eidbaooo"))
  }

  test("testExample2") {
    assert(!PermutationInString.checkInclusion("ab", "eidboaoo"))
  }
}

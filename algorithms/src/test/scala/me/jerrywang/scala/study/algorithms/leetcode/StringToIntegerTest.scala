package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class StringToIntegerTest extends FunSuite {

  test("testPositiveNumber") {
    assert(StringToInteger.myAtoi("42") == 42)
  }

  test("testPositiveNumberWithLeadingSpaces") {
    assert(StringToInteger.myAtoi("   42") == 42)
  }

  test("testPositiveNumberWithTrailingSpaces") {
    assert(StringToInteger.myAtoi("42   ") == 42)
  }

  test("testPositiveNumberWithLeadingWords") {
    assert(StringToInteger.myAtoi("words and 42") == 0)
  }

  test("testPositiveNumberWithTrailingWords") {
    assert(StringToInteger.myAtoi("42 with words") == 42)
  }

  test("testPositiveNumberWithPlusSign") {
    assert(StringToInteger.myAtoi("+42") == 42)
  }

  test("testPositiveNumberWithPlusSignAndLeadingSpaces") {
    assert(StringToInteger.myAtoi("   +42") == 42)
  }
}

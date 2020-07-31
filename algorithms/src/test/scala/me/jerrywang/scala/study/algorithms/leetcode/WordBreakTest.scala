package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class WordBreakTest extends AnyFunSuite {

  test("testExample1") {
    assert(WordBreak.wordBreak("leetcode", List("leet", "code")))
  }

  test("testExample2") {
    assert(WordBreak.wordBreak("applepenapple", List("apple", "pen")))
  }

  test("testExample3") {
    assert(!WordBreak.wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")))
  }
}

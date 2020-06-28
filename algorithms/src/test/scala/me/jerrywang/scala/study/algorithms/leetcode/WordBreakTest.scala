package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class WordBreakTest extends FunSuite {

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

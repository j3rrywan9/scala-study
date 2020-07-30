package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class VerifyingAnAlienDictionaryTest extends FunSuite {

  test("testExample1") {
    assert(VerifyingAnAlienDictionary.isAlienSorted(Array("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
  }

  test("testExample2") {
    assert(!VerifyingAnAlienDictionary.isAlienSorted(Array("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"))
  }

  test("testExample3") {
    assert(!VerifyingAnAlienDictionary.isAlienSorted(Array("apple", "app"), "abcdefghijklmnopqrstuvwxyz"))
  }
}

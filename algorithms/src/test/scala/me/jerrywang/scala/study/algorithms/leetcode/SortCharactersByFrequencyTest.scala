package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.FunSuite

class SortCharactersByFrequencyTest extends FunSuite {

  test("testExample1") {
    assert(SortCharactersByFrequency.frequencySort("tree") == "eert")
  }

  test("testExample2") {
    assert(SortCharactersByFrequency.frequencySort("cccaaa") == "aaaccc")
  }

  test("testExample3") {
    assert(SortCharactersByFrequency.frequencySort("Aabb") == "bbAa")
  }
}

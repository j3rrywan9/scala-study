package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class GoatLatinTest extends AnyFunSuite {

  test("testExample1") {
    assert(GoatLatin.toGoatLatin("I speak Goat Latin") == "Imaa peaksmaaa oatGmaaaa atinLmaaaaa")
  }

  test("testExample2") {
    assert(GoatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog") == "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
  }
}

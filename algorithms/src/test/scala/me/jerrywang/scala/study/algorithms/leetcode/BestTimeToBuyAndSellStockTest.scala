package me.jerrywang.scala.study.algorithms.leetcode

import org.scalatest.funsuite.AnyFunSuite

class BestTimeToBuyAndSellStockTest extends AnyFunSuite {

  test("testExample1") {
    assert(BestTimeToBuyAndSellStock.maxProfit(Array(7, 1, 5, 3, 6, 4)) == 5)
  }

  test("testExample2") {
    assert(BestTimeToBuyAndSellStock.maxProfit(Array(7, 6, 4, 3, 1)) == 0)
  }
}

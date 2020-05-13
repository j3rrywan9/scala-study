package me.jerrywang.scala.study.algorithms.leetcode

// LC 121
object BestTimeToBuyAndSellStock {

  def maxProfit(prices: Array[Int]): Int = {
    var minPrice = Int.MaxValue
    var maxProfit = 0

    for (i <- prices.indices) {
      if (prices(i) < minPrice) {
        minPrice = prices(i)
      } else if (prices(i) - minPrice > maxProfit) {
        maxProfit = prices(i) - minPrice
      }
    }

    maxProfit
  }

  def main(args: Array[String]): Unit = {
    println(BestTimeToBuyAndSellStock.maxProfit(Array(7, 1, 5, 3, 6, 4)))
    println(BestTimeToBuyAndSellStock.maxProfit(Array(7, 6, 4, 3, 1)))
  }
}

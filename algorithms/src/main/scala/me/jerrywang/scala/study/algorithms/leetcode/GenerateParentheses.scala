package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 22
object GenerateParentheses {

  def generateParenthesis(n: Int): List[String] = {
    val ans = mutable.ListBuffer.empty[String]
    backtrack(ans, "", 0, 0, n)
    ans.toList
  }

  private def backtrack(ans: mutable.ListBuffer[String], cur: String, open: Int, close: Int, max: Int): Unit = {
    if (cur.length == max * 2) {
      ans += cur
      return
    }

    if (open < max)
      backtrack(ans, cur + "(", open + 1, close, max)
    if (close < open)
      backtrack(ans, cur + ")", open, close + 1, max)
  }

  def main(args: Array[String]): Unit = {
    println(GenerateParentheses.generateParenthesis(3).mkString("[", ", ", "]"))
  }
}

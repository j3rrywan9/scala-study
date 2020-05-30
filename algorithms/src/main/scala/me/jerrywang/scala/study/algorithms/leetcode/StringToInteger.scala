package me.jerrywang.scala.study.algorithms.leetcode

import scala.util.control.Breaks._

// LC 8
object StringToInteger {

  def myAtoi(str: String): Int = {
    if (str == null || str.length == 0)
      return 0

    val trimmedStr = str.trim
    var start = 0
    var ans = 0
    var sign = 1
    val len = trimmedStr.length

    val firstChar = if (trimmedStr.toCharArray.length > 0) trimmedStr.charAt(0) else ' '

    if (firstChar == '-' || firstChar == '+') {
      sign = if (firstChar == '+') 1 else -1
      start += 1
    }

    breakable {
      for (i <- start until len) {
        val digit = trimmedStr.charAt(i) - '0'

        if (digit < 0 || digit > 9)
          break
        if (ans > Int.MaxValue / 10 || (ans == Int.MaxValue / 10 && Int.MaxValue % 10 < digit)) {
          return if (sign == 1) Int.MaxValue else Int.MinValue
        }
        else
          ans = ans * 10 + digit
      }
    }

    sign * ans
  }
}

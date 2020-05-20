package me.jerrywang.scala.study.algorithms.leetcode

// LC 43
object MultiplyStrings {

  def multiply(num1: String, num2: String): String = {
    val n1 = num1.length
    val n2 = num2.length
    val product = Array.fill[Int](n1 + n2)(0)

    for (i <- n1 - 1 to 0 by -1) {
      for (j <- n2 - 1 to 0 by -1) {
        val d1 = num1.charAt(i) - '0'
        val d2 = num2.charAt(j) - '0'

        product(i + j + 1) += d1 * d2
      }
    }

    var carry = 0

    for (i <- product.length - 1 to 0 by -1) {
      val temp = (product(i) + carry) % 10
      carry = (product(i) + carry) / 10
      product(i) = temp
    }

    val sb = new StringBuilder

    for (num <- product)
      sb.append(num)

    while (sb.nonEmpty && sb.charAt(0) == '0')
      sb.deleteCharAt(0)

    if (sb.isEmpty) "0" else sb.toString()
  }

  def main(args: Array[String]): Unit = {
    println(multiply("2", "3"))
    println(multiply("123", "456"))
  }
}

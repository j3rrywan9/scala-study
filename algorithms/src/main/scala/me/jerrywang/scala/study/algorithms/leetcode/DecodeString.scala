package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 394
object DecodeString {

  def decodeString(s: String): String = {
    val intStack = mutable.Stack.empty[Int]
    val strStack = mutable.Stack.empty[mutable.StringBuilder]
    var current = new mutable.StringBuilder
    var k = 0

    for (ch <- s.toCharArray) {
      if (ch.isDigit) {
        k = k * 10 + ch - '0'
      } else if (ch == '[') {
        intStack.push(k)
        strStack.push(current)
        current = new mutable.StringBuilder
        k = 0
      } else if (ch == ']') {
        val temp = current
        current = strStack.pop()

        for (_ <- intStack.pop() until 0 by -1) {
          current.append(temp)
        }
      } else {
        current.append(ch)
      }
    }

    current.toString()
  }

  def main(args: Array[String]): Unit = {
    println(decodeString("3[a]2[bc]"))
    println(decodeString("3[a2[c]]"))
    println(decodeString("2[abc]3[cd]ef"))
  }
}

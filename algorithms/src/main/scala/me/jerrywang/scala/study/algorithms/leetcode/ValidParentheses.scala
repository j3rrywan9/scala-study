package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 20
object ValidParentheses {

  // Mappings between closing brackets and opening brackets
  private val mappings = mutable.Map(')' -> '(', '}' -> '{', ']' ->'[')

  def isValid(s: String): Boolean = {
    val stack = mutable.Stack.empty[Char]

    for (i <- 0 until s.length) {
      val c = s.charAt(i)

      // If current character is a closing bracket
      if (this.mappings.contains(c)) {
        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        val topElement = if (stack.isEmpty) '#' else stack.pop()

        // If the mapping for this bracket doesn't match the stack's top element, return false
        if (topElement != this.mappings(c)) return false
      } else {
        // If current character is an opening bracket, push it to the stack
        stack.push(c)
      }
    }

    // If the stack still contains elements, then it is an invalid expression
    stack.isEmpty
  }

  def main(args: Array[String]): Unit = {
    println(ValidParentheses.isValid("()"))
    println(ValidParentheses.isValid("()[]{}"))
    println(ValidParentheses.isValid("(]"))
    println(ValidParentheses.isValid("([)]"))
    println(ValidParentheses.isValid("{[]}"))
  }
}

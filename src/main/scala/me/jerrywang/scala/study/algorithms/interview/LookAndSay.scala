package me.jerrywang.scala.study.algorithms.interview

/**
  * Seed: 1
  * Sequence: 11, 21, 1211, 111221
  *
  * Seed: 33
  * Sequence: 23, 1213, 11121113, 31123113
  *
  * Write a non-recursive function to take a seed, output the sequence after specified iterations:
  *
  * def encode(seed: Int, iterations: Int): String
  *
  * For example:
  * encode(1, 4) = "111221"
  */
object LookAndSay extends App {
  def encode(seed: Int, iterations: Int): String = {
    var input = seed.toString

    if (iterations < 1) return input

    var retVal = ""
    var prev = input.substring(0, 1)
    var current = input.substring(0, 1)

    for (_ <- 0 until iterations) {
      var counter = 0
      for (j <- 0 until input.length) {
        current = input.substring(j, j + 1)
        if (current.equals(prev)) counter += 1
        else {
          retVal = retVal + counter.toString + prev
          counter = 1
          prev = current
        }
      }
      retVal = retVal + counter.toString + prev
      input = retVal
      prev = input.substring(0, 1)
      current = input.substring(0, 1)
      retVal = ""
    }
    return input
  }

  println(encode(1, 4))
  println(encode(33, 4))
}

package me.jerrywang.scala.study.algorithms.leetcode

// LC 567
object PermutationInString {

  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length> s2.length)
      return false

    val s1map = new Array[Int](26)

    // Store the frequency of occurrence of all the characters in the short string s1
    for (i <- 0 until s1.length) {
      s1map(s1.charAt(i) - 'a') += 1
    }

    // For every possible substring of s2 of the same length as that of s1
    for (i <- 0 to s2.length - s1.length) {
      val s2map = new Array[Int](26)

      // Store the frequency of occurrence of all the characters in the substring
      for (j <- 0 until s1.length) {
        s2map(s2.charAt(i + j) - 'a') += 1
      }

      // If the two arrays obtained are identical for any such window
      if (matches(s1map, s2map))
        return true
    }

    false
  }

  def matches(s1map: Array[Int], s2map: Array[Int]): Boolean = {
    for (i <- 0 until 26) {
      if (s1map(i) != s2map(i))
        return false
    }

    true
  }
}

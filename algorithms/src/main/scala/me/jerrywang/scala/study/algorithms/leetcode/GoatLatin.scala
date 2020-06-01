package me.jerrywang.scala.study.algorithms.leetcode

// LC 824
object GoatLatin {

  def toGoatLatin(S: String): String = {
    val Vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    var t = 1
    val ans = new StringBuilder

    for (word <- S.split(" ")) {
      val firstChar = word.charAt(0)

      if (Vowels.contains(firstChar))
        ans.append(word)
      else {
        ans.append(word.substring(1))
        ans.append(word.substring(0, 1))
      }

      ans.append("ma")

      for (_ <- 0 until t)
        ans.append("a")

      t += 1
      ans.append(" ")
    }

    ans.deleteCharAt(ans.length - 1)
    ans.toString()
  }
}

package me.jerrywang.scala.study.algorithms.leetcode

// LC 208
class TrieNode(links: Array[TrieNode], var isEnd: Boolean) {

  def this() = {
    this(new Array[TrieNode](TrieNode.R), false)
  }

  def containsKey(ch: Char): Boolean = links(ch - 'a') != null

  def get(ch: Char): TrieNode = links(ch - 'a')

  def put(ch: Char, node: TrieNode): Unit = links(ch - 'a') = node

  def setEnd(): Unit = isEnd = true
}

object TrieNode {
  val R = 26
}

class Trie(root: TrieNode) {

  def this() = {
    this(new TrieNode())
  }

  def insert(word: String): Unit = {
    var node = root

    for (i <- 0 until word.length) {
      val currentChar = word.charAt(i)

      if (!node.containsKey(currentChar)) {
        node.put(currentChar, new TrieNode())
      }

      node = node.get(currentChar)
    }

    node.setEnd()
  }
}

object ImplementTrie {

  def main(args: Array[String]): Unit = {
    val trie = new Trie()
  }
}

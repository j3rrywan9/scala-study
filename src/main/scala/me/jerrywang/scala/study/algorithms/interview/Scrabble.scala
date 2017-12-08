package me.jerrywang.scala.study.algorithms.interview

import java.io.{ FileNotFoundException, IOException }
import scala.collection.mutable.{ ListBuffer, Map }
import scala.io.Source
import scala.io.StdIn.readLine

object Scrabble extends App {
  val WordsPath = "/usr/share/dict/words"
  val map = Map.empty[String, ListBuffer[String]]

  try {
    for (word <- Source.fromFile(WordsPath).getLines) {
      val sortedWord = word.toLowerCase.sorted

      if (!map.contains(sortedWord))
        map(sortedWord) = ListBuffer[String]()
      map(sortedWord) += word
    }

    // map.foreach { case (sortedWord, listOfAnagrams) => println(sortedWord + " -> " + listOfAnagrams.mkString("(", ", ", ")")) }

    while (true) {
      val userInput = readLine("What letters? ")
      val sortedUserInput = userInput.toLowerCase.sorted

      if (map.contains(sortedUserInput))
        println(map(sortedUserInput).mkString("[", ", ", "]"))
      else
        println("No valid English words found.")
    }
  } catch {
    case _: FileNotFoundException => println("Couldn't find file " + WordsPath)
    case _: IOException => println("Got an IOException!")
  }
}

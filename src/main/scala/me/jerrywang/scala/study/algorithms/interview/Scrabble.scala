package me.jerrywang.scala.study.algorithms.interview

import java.io.{ FileNotFoundException, IOException }

import scala.collection.mutable.{ ListBuffer, Map }
import scala.io.Source
import scala.io.StdIn.readLine
import scala.util.{ Failure, Success, Try }

object Scrabble extends App {
  val WordsPath = "/usr/share/dict/words"
  val map = Map.empty[String, ListBuffer[String]]

  try {
    for (word <- Source.fromFile(WordsPath).getLines) {
      val sortedWord = word.toLowerCase.sorted

      Try(map(sortedWord)) match {
        case Success(listOfAnagrams) => listOfAnagrams += word
        case Failure(_) => map(sortedWord) = new ListBuffer[String] += word
      }
    }

    // map.foreach { case (sortedWord, listOfAnagrams) => println(sortedWord + " -> " + listOfAnagrams.mkString("(", ", ", ")")) }

    while (true) {
      val userInput = readLine("What letters? ")
      val sortedUserInput = userInput.toLowerCase.sorted

      Try(map(sortedUserInput)) match {
        case Success(listOfAnagrams) => println(listOfAnagrams.mkString("[", ", ", "]"))
        case Failure(_) => println("No valid English words found.")
      }
    }
  } catch {
    case _: FileNotFoundException => println("Couldn't find file " + WordsPath)
    case _: IOException => println("Got an IOException!")
  }
}

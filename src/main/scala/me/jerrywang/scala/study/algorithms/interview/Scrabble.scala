package me.jerrywang.scala.study.algorithms.interview

import java.io.{ FileNotFoundException, IOException }

import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable.{ ListBuffer, Map }
import scala.io.Source
import scala.io.StdIn.readLine

object Scrabble extends App with LazyLogging {
  val WordsPath = "/usr/share/dict/words"
  val map = Map.empty[String, ListBuffer[String]]

  try {
    for (word <- Source.fromFile(WordsPath).getLines) {
      val sortedWord = word.toLowerCase.sorted

      map.get(sortedWord) match {
        case Some(listOfAnagrams) => listOfAnagrams += word
        case None => map(sortedWord) = new ListBuffer[String] += word
      }
    }

    map.foreach { case (sortedWord, listOfAnagrams) => logger.debug(sortedWord + " -> " + listOfAnagrams.mkString("(", ", ", ")")) }

    while (true) {
      val userInput = readLine("What letters? ")
      val sortedUserInput = userInput.toLowerCase.sorted

      map.get(sortedUserInput) match {
        case Some(listOfAnagrams) => println(listOfAnagrams.mkString("[", ", ", "]"))
        case None => println("No valid English words found.")
      }
    }
  } catch {
    case _: FileNotFoundException => println("Couldn't find file " + WordsPath)
    case _: IOException => println("Got an IOException!")
  }
}

package me.jerrywang.scala.study.algorithms.interview

import java.io.{ FileNotFoundException, IOException }

import com.typesafe.scalalogging.LazyLogging
import scala.collection.mutable
import scala.io.Source
import scala.io.StdIn.readLine

object Scrabble extends App with LazyLogging {
  val WordsPath = "/usr/share/dict/words"
  val map = mutable.Map.empty[String, mutable.ListBuffer[String]]

  try {
    for (word <- Source.fromFile(WordsPath).getLines) {
      val sortedWord = word.toSeq.sorted.unwrap
      map(sortedWord) = map.getOrElse(sortedWord, new mutable.ListBuffer[String]) += word
    }

    map.foreach { case (sortedWord, listOfAnagrams) => logger.debug(sortedWord + " -> " + listOfAnagrams.mkString("(", ", ", ")")) }

    while (true) {
      val userInput = readLine("What letters? ")
      val sortedUserInput = userInput.toLowerCase.toSeq.sorted.unwrap

      map.get(sortedUserInput) match {
        case Some(listOfAnagrams) => println(listOfAnagrams.mkString("[", ", ", "]"))
        case None                 => println("No valid English words found.")
      }
    }
  } catch {
    case _: FileNotFoundException => println("Couldn't find file " + WordsPath)
    case _: IOException           => println("Got an IOException!")
  }
}

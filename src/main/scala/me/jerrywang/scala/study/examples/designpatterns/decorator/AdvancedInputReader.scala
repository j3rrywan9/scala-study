package me.jerrywang.scala.study.examples.designpatterns.decorator

import java.io.BufferedReader

import scala.collection.JavaConverters._

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
  override def readLines(): Stream[String] = reader.lines().iterator().asScala.toStream
}

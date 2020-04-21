package me.jerrywang.scala.study.examples.designpatterns.decorator

import java.io.BufferedReader

import scala.jdk.CollectionConverters._

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
  override def readLines(): LazyList[String] = reader.lines().iterator().asScala.to(LazyList)
}

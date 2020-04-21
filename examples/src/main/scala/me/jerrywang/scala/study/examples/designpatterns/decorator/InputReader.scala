package me.jerrywang.scala.study.examples.designpatterns.decorator

trait InputReader {
  def readLines(): LazyList[String]
}

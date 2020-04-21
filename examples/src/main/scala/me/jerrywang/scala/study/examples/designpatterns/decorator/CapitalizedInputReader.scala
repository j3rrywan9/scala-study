package me.jerrywang.scala.study.examples.designpatterns.decorator

trait CapitalizedInputReader extends InputReader {
  abstract override def readLines(): LazyList[String] = super.readLines().map(_.toUpperCase)
}

package me.jerrywang.scala.study.examples.composition

class Watch(brand: String, initialTime: Long) {
  def getTime(): Long = System.currentTimeMillis() - initialTime
}

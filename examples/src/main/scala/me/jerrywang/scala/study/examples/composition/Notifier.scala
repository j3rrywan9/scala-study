package me.jerrywang.scala.study.examples.composition

trait Notifier {
  val notificationMessage: String

  def printNotification(): Unit = {
    println(notificationMessage)
  }

  def clear()
}

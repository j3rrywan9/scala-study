package me.jerrywang.scala.study.examples.composition

trait AlarmNotifier {
  this: Notifier =>

  def trigger(): String
}

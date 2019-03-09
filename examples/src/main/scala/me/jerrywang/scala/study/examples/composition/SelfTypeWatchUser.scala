package me.jerrywang.scala.study.examples.composition

object SelfTypeWatchUser {
  def main(args: Array[String]): Unit = {
    val watch = new Watch("alarm with notification", 1000L) with AlarmNotifier with Notifier {
      override def trigger(): String = "Alarm triggered."

      override def clear(): Unit = {
        println("Alarm cleared.")
      }

      override val notificationMessage: String = "The notification."
    }

    println(watch.trigger())
    watch.printNotification()
    println(s"The time is ${watch.getTime()}.")
    watch.clear()
  }
}

package me.jerrywang.scala.study.examples.implicitparams

import Greeter.PreferredPrompt

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
}

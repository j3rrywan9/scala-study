package me.jerrywang.scala.study.examples.implicitparams

import JoesPrefs._

object Greeter extends App {
  class PreferredPrompt(val preference: String)

  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println("Welcome, " + name + ". The system is ready.")
    println(prompt.preference)
  }

  Greeter.greet("Joe")
}

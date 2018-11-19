package me.jerrywang.scala.study.examples.implicitparams

import JoesPrefs._

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter extends App {
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
    println("Welcome, " + name + ". The system is ready.")
    println(prompt.preference)
    print("But while you work, ")
    println("why not drink a cup of " + drink.preference + "?")
    println(prompt.preference)
  }

  Greeter.greet("Joe")
}

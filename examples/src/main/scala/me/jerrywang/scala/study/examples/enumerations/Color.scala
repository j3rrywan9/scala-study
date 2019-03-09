package me.jerrywang.scala.study.examples.enumerations

object Color extends Enumeration {
  // This type alias allows us to use `Color` instead of `Color.Value` after importing `Color._`
  type Color = Value
  val Red, Green, Blue = Value
}

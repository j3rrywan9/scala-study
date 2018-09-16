package me.jerrywang.scala.study.examples.enumerations

import me.jerrywang.scala.study.examples.enumerations.Color._

case class Shape(name: String, color: Color) {
  override def toString = s"A $name in $color"
}

object Shape {
  def main(args: Array[String]) = {
    val redCircle = Shape("circle", Red)
    println(redCircle)
  }
}

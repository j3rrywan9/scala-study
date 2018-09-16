package me.jerrywang.scala.study.examples.enumerations

import me.jerrywang.scala.study.examples.enumerations.Color._

/**
  * A shape with color.
  *
  * @param name the name of the shape.
  * @param color the color of the shape.
  */
case class Shape(name: String, color: String) {
  override def toString = s"A $name in $color"
}

object Shape {
  /** Enables implicit conversions. */
  import scala.language.implicitConversions

  /**
    * Converts an enumerated value to string.
    *
    * @param value the enumerated value to be converted.
    * @tparam A the type extends `scala.Enumeration`.
    */
  implicit def enumeratedValueToString[A <: Enumeration](value: A#Value): String = value.toString

  def main(args: Array[String]): Unit = {
    val redCircle = Shape("circle", Red)
    println(redCircle)
  }
}

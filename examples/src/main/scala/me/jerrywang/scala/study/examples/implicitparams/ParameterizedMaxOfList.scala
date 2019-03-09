package me.jerrywang.scala.study.examples.implicitparams

/**
 * A demo of context bound.
 */
object ParameterizedMaxOfList extends App {
  def maxOfList[T: Ordering](elements: List[T]): T = elements match {
    case List()  => throw new IllegalArgumentException("Empty list!")
    case List(x) => x
    case x :: rest =>
      val maxOfRest = maxOfList(rest) // (ordering) is implicit
      if (implicitly[Ordering[T]].gt(x, maxOfRest)) x
      else maxOfRest
  }

  println(maxOfList(List(2, -4, 5, 7, 1)))
  println(maxOfList(List("apple", "pineapple", "orange", "banana")))
}

package me.jerrywang.scala.study.examples.option

object OptionDemo extends App {

  final val StateCapitals = Map(
    "AL" -> Some("Montgomery"),
    "AK" -> Some("Juneau"),
    "AZ" -> Some("Phoenix"),
    "CA" -> Some("Sacramento"),
    "CO" -> Some("Denver"),
    "CT" -> Some("Hartford"),
    "DE" -> Some("Dover"),
    "GA" -> Some("Atlanta"),
    "ID" -> Some("Boise"),
  )

  println(StateCapitals.get("CA").map(_.headOption))
  println(StateCapitals.get("CA").map(_.headOption).flatten)
  println(StateCapitals.get("CA").flatMap(_.headOption))
  println(StateCapitals.get("CA").fold("Unknown")(_.get))
  println(StateCapitals.get("CA").filter(_.get.length < 5).getOrElse("Unsatisfied predicate"))
}

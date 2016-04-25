object Upper {
  def upper(strings: String*) = strings.map(_.toUpperCase())
}

object upper2 {
  def main(args: Array[String]): Unit = {
    println(Upper.upper("A", "First", "Scala", "Program"))
  }
}

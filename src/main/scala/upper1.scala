object upper1 {

  class Upper {
    def upper(strings: String*): Seq[String] = {
      strings.map((s: String) => s.toUpperCase())
    }
  }

  def main(args: Array[String]): Unit = {
    val up = new Upper
    Console.println(up.upper("Hello", "World!"))
  }
}

# Enumerations

Scala does not need special syntax for enumerations.
Instead, there's a class in its standard library, `scala.Enumeration`.

To create a new enumeration, you define an object that extends this class, as in the following example, which defines a new enumeration of `Color`s:
```scala
object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}
```
Scala lets you also shorten several successive `val` or `var` definitions with the same right-hand side.
Equivalently to the above you could write:
```scala
object Color extends Enumeration {
  val Red, Green, Blue = Value
}
```
This object definition provides three values: `Color.Red`, `Color.Green`, and `Color.Blue`.
You could also import everything in `Color` with:
```scala
import Color._
```

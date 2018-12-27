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
and then just use `Red`, `Green`, and `Blue`.
But what is the type of these values?

`Enumeration` defines an inner class named `Value`, and the same-named parameterless `Value` method returns a fresh instance of that class.
In other words, a value such as `Color.Red` is of type `Color.Value`;
`Color.Value` is the type of all enumeration values defined in object `Color`.
It's a path-dependent type, with `Color` being the path and `Value` being the dependent type.
What's significant about this is that it is a completely new type, different from all other types.

You can associate names with enumeration values by using a different overloaded variant of the `Value` method:
```scala
object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}
```
You can iterate over the values of an enumeration via the set returned by the enumeration's `values` method:
```scala
for (d <- Direction.values) print(d + " ")
```
Values of an enumeration are numbered from 0, and you can find out the number of an enumeration value by its `id` method:
```scala
Direction.East.id
```

## API

```scala
/** The type of the enumerated values. */
abstract class Value extends Ordered[Value] with Serializable {
}

/** Creates a fresh value, part of this enumeration. */
protected final def Value: Value = Value(nextId)

/** Creates a fresh value, part of this enumeration, called `name`. */
protected final def Value(name: String): Value = Value(nextId, name)
```

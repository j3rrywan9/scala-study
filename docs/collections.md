# Collections

## Arrays

In Scala, arrays are zero based, and you access an element by specifying an index in parentheses.
So the first element in a Scala array named `steps` is `steps(0)`, not `steps[0]`.

Arrays are simply instances of classes like any other class in Scala.
When you apply parentheses surrounding one or more values to a variable, Scala will transform the code into an invocation of a method named `apply` on that variable.
Thus accessing an element of an array in Scala is simply a method call like any other.
```scala
val numNames = Array("zero", "one", "two")
```

## Lists

One of the big ideas of the functional sytle of programming is that methods should not have side effects.
A method's only act should be to compute and return a value.
Applying this functional philosophy to the world of objects means making objects immutable.

For an immutable sequence of objects that share the same type you can use Scala's **List** class.
Scala's List, `scala.List`, differs from Java's `java.util.List` type in that Scala Lists are always immutable (whereas Java Lists can be mutable).
More generally, Scala's List is designed to enable a functional style of programming.

Creating a list is easy:
```scala
val oneTwoThree = List(1, 2, 3)
```

## Sets

Scala provides mutable and immutable alternatives for sets and maps, but uses the same simple names for both versions.

If you want a mutable set, you'll need to use an *import*:
```scala
import scala.collection.mutable.Set

val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)
```

## Maps


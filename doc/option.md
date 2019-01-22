# Option

Scala has a standard type named `Option` for optional values.
Such a value can be of two forms:
`Some(x)`, where `x` is the actual value, or the `None` object, which represents a missing value.

Optional values are produced by some of the standard operations on Scala's collections.
For instance, the `get` method of Scala's `Map` produces `Some(value)` if a `value` corresponding to a given key has been found, or `None` if the given key is not defined in the `Map`.

The most common way to take optional values apart is through a pattern match.

The `Option` type is used frequently in Scala programs.

For Scala, the approach would not work at because it is possible to store value types in hash maps, and `null` is not a legal element for a value type.

By contrast, Scala encourages the use of `Option` to indicate an optional value.

## API

```scala
def isDefined: Boolean = !isEmpty
```
Returns true if the option is an instance of `scala.Some`, false otherwise.

```scala
@inline final def map[B](f: A => B): Option[B] =
  if (isEmpty) None else Some(f(this.get))
```
Returns a `scala.Some` containing the result of applying `f` to this `scala.Option`'s value if this `scala.Option` is nonempty.

```scala
@inline final def fold[B](ifEmpty: => B)(f: A => B): B =
  if (isEmpty) ifEmpty else f(this.get)
```
Returns the result of applying `f` to this `scala.Option`'s value if the `scala.Option` is nonempty.
Otherwise, evaluates expression `ifEmpty`.
This is equivalent to `scala.Option map f getOrElse ifEmpty`.

```scala
@inline final def flatMap[B](f: A => Option[B]): Option[B] =
  if (isEmpty) None else f(this.get)
```
Returns the result of applying `f` to this `scala.Option`'s value if this `scala.Option` is nonempty.

```scala
def flatten[B](implicit ev: A <:< Option[B]): Option[B] =
  if (isEmpty) None else ev(this.get)
```

```scala
@inline final def filter(p: A => Boolean): Option[A] =
  if (isEmpty || p(this.get)) this else None
```
Returns this `scala.Option` if it is nonempty and applying the predicate `p` to this `scala.Option`'s value returns true.

```scala
@inline final def getOrElse[B >: A](default: => B): B =
  if (isEmpty) default else this.get
```
Returns the option's value if the option is nonempty, otherwise return the result of evaluating `default`.

```scala
@inline final def orNull[A1 >: A](implicit ev: Null <:< A1): A1 =
  this getOrElse ev(null)
```
Returns the option's value if it is nonempty, or `null` if it is empty.

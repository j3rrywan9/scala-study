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

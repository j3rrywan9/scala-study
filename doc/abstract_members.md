# Abstract Members

## Type Members

The term *abstract type* in Scala means a type declared (with the `type` keyword) to be a member of a class or trait, without specifying a definition.

One reason to use a type member is to define a short, descriptive alias for a type whose real name is more verbose, or less obvious in meaning, than the alias.

## Abstract `val`s

It gives a name and type for a `val`, but not its value.
This value has to be provided by a concrete `val` definition in a subclass.

## Abstract `var`s

## Initializing abstract `val`s

## Abstract `type`s

Like all other abstract declarations, an abstract type declaration is a placeholder for something that will be defined concretely in subclasses.
In this case, it is a type that will be defined further down the class hierarchy.

## Path-dependent types

So this shows that objects in Scala can have types as members.

A path-dependent type resembles the syntax for an inner class type in Java, but there is crucial difference: a path-dependent type names an outer *object*, whereas an inner class type names an outer *class*.
Java-style inner class types can also be expressed in Scala, but they are written differently.
Consider these two classes, `Ounter` and `Inner`:
```scala
class Outer {
  class Inner
}
```
In Scala, the inner class is addressed using the expression `Outer#Inner` instead of Java's `Outer.Inner`.
The `.` syntax is reserved for objects.

## Refinement types

## [Enumerations](enumerations.md)

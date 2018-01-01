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

## Refinement types

## Enumerations

Scala does not need special syntax for enumerations.
Instead, there's a class in its standard library, `scala.Enumeration`.

To create a new enumeration, you define an object that extends this class.

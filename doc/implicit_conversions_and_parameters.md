# Implicit Conversions and Parameters

There's a fundamental difference between your own code and other people's libraries: You can change or extend your own code as you wish, but if you want to use someone else's libraries, you usually have to take them as they are.
A number of constructs have sprung up in programming languages to alleviate this problem.

Scala's answer is implicit conversions and parameters.
These can make existing libraries much more pleasant to deal with by letting you leave out tedious, obvious details that obscure the interesting parts of your code.

## Implicit conversions

Implicit conversions are often helpful for working with two bodies of software that were developed without each other in mind.
Each library has its own way to encode a concept that is essentially the same thing. 
Implicit conversions help by reducing the number of explicit conversions that are needed from one type to another.

The first step is to write an implicit conversion between the two types.
Here is an implicit conversion from functions to action listeners:
```scala
implicit def function2ActionListener(f: ActionEvent => Unit) =
  new ActionListener {
    def actionPerformed(event: ActionEvent) = f(event)
  }
```
This is a one-argument method that takes a function and returns an action listener.
Like any other one-argument method, it can be called directly and have its result passed on to another expression:
```scala
button.addActionListener(
  function2ActionListener(
    (_: ActionEvent) => println("pressed!")
  )
)
```
Because `function2ActionListener` is marked as implicit, it can be left out and the compiler will insert it automatically.
Here is t he result:
```scala
button.addActionListener(
  (_: ActionEvent) => println("pressed!")
)
```
The way this code works is that the compiler first tries to compile it as is, but it sees a type error.
Before giving up, it looks for an implicit conversion that can repair the problem.
It tries that conversion method, sees that it works, and moves on.

## Rules for implicits

Implicit definitions are those that the compiler is allowed to insert into a program in order to fix any of its type errors.

Implicit conversions are governed by the following general rules:

Marking rule: Only definitions marked `implicit` are available.
The `implicit` keyword is used to mark which declarations the compiler may use as implicits.
You can use it to mark any variable, function, or object definition.

Scope rule: An inserted implicit conversion must be in scope as a single identifier, or be associated with the source or target type of the conversion.
The Scala compiler will only consider implicit conversions that are in scope.
To make an implicit conversion available, therefore, you must in some way bring it into scope.
Moreover, with one exception, the implicit conversion must be in scope *as a single identifier*.
In fact, it is common for libraries to include a `Preamble` object including a number of useful implicit conversions.
Code that uses the library can then do a single "`import Preamble._`" to access the library's implicit conversions.

There's one exception to the "single identifier" rule.
The compiler will also look for implicit definitions in the companion object of the source or expected target types of the conversion.

The Scope Rule helps with modular reasoning.
When you read code ina file, the only things you need to consider from other files are those that are either imported or are explicitly referenced through a fully qualified name.

### Naming an implicit conversion

Implicit conversions can have arbitrary names.
The name of an implicit conversion matters only in two situations:
If you want to write it explicitly in a method application and for determining which implicit conversions are available at any place in the program.

### Where implicits are tried

There are three places implicits are used in the language: conversions to an expected type, conversions of the receiver of a selection, and implicit parameters.

Implicit conversions to an expected type let you use one type in a context where a different type is expected.

Conversions for the receiver let you adapt the receiver of a method call (i.e., the object on which a method is invoked), if the method is not applicable on the original type.

Implicit parameters, on the other hand, are usually used to provide more information to the called function about what the caller wants.

## Implicit conversion to an expected type

Implicit conversion to an expected type is the first place the compiler will use implicits.
The rule is simple.
Whenever the compiler sees an `X`, but needs a `Y`, it will look for an implicit function that converts `X` to `Y`.

The `scala.Predef` object, which is implicitly imported into every Scala program, defines implicit conversions that convert "smaller" numeric types to "larger" ones.

## Converting the receiver

Implicit conversions also apply to the receiver of a method call, the object on which the method is invoked.
This kind of implicit conversion has two main uses.
First, receiver conversions allow smoother integration of a new class into an existing class hierarchy.
And second, they support writing DSLs within the language.

### Interoperating with new types

As mentioned previously, one major use of receiver conversions is allowing smoother integration of new types with existing types.
In particular, they allow you to enable client programmers to use instances of existing types as if they were instances of your new type.

### Simulating new syntax

The other major use of implicit conversions is to simulate adding new syntax.

Recall that you can make a `Map` using syntax like this:
```scala
Map(1 -> "one", 2 -> "two", 3 -> "three")
```
Instead, `->` is a method of the class `ArrowAssoc`, a class defined inside the standard Scala preamble `scala.Predef`.
The preamble also defines an implicit conversion from `Any` to `ArrowAssoc`.
When you write `1 -> "one"`, the compiler inserts a conversion from `1` to `ArrowAssoc` so that the `->` method can be found.

Whenever you see someone calling methods that appear not to exist in the receiver class, they are probably using implicits.

### Implicit classes

Implicit classes were added in Scala 2.10 to make it easier to write rich wrapper classes.
An implicit class is a class that is preceded by the `implicit` keyword.
For any such class, the compiler generates an implicit conversion from the class's constructor parameter to the class itself.
Such a conversion is just what you need if you plan to use the class for the rich wrappers pattern.

An implicit class cannot be a case class, and its constructor must have exactly one parameter.
Also, an implicit class must be located within some other object, class, or trait.
In practice, so long as you use implicit classes as rich wrappers to add a few methods onto an existing class, these restrictions should not matter.

## Implicit parameters

The remaining place the compiler inserts implicits is within argument lists.
The compiler will sometimes replace `someCall(a)` with `someCall(a)(b)`, or `new SomeClass(a)` with `new SomeClass(a)(b)`, thereby adding a missing parameter list to complete a function call.
It is the entire last curried parameter list that's supplied, not just the last parameter.

Note that the `implicit` keyword applies to an entire parameter list, not to individual parameters.

Because the compiler selects implicit parameters by matching types of parameters against types of values in scope, implicit parameters usually have "rare" or "special" enough types that accidental matches are unlikely.

Another thing to know about implicit parameters is that they are perhaps most often used to provide information about a type mentioned `explicitly` in an earlier parameter list, similar to the type classes of Haskell.

### A style rule for implicit parameters

As a style rule, it is best to use a custom named type in the types of implicit parameters.

## Context bounds

Note that when you use `implicit` on a parameter, not only will the compiler try *supply* that parameter with an implicit value, but the compiler will also *use* that parameter as an available implicit in the body of the method!
```scala
def implicitly[T](implicit t: T) = t
```
The effect of calling `implicitly[Foo]` is that the compiler will look for an implicit definition of type `Foo`.
It will then call the `implicitly` method with that object, which in turn returns the object right back.
Thus you can write `implicitly[Foo]` whenever you want to find an implicit object of type `Foo` in the current scope.

Because this pattern is common, Scala lets you leave out the name of this parameter and shorten the method header by using a *context bound*.

The syntax `[T : Ordering]` is a context bound, and it does two things.
First, it introduces a type parameter `T` as normal.
Second,it adds an implicit parameter of type `Ordering[T]`.

## When multiple conversions apply

If one of the available conversions is strictly *more specific* than the others, then the compiler will choose the more specific one.

### Debugging implicits

Sometimes you might wonder why the compiler did not find an implicit conversion that you think should apply.
In that case it helps to write the conversion out explicitly.
If that also gives an error message, you then know why the compiler could not apply your implicit.

When you are debugging a program, it can sometimes help to see what implicit conversions the compiler is inserting.
The `-Xprint:typer` option to the compiler is useful for this.
If you run `scalac` with this option, the compiler will show you what your code looks like after all implicit conversions have been added by the type checker.

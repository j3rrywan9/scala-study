# Learning Scala

## Variables
Scala has two kinds of variables, vals and vars. A **val** is similar to a final variable in Java. Once initialized, a val can never be reassigned. A var, by contrast, is similar to a non-final variable in Java. A var can be reassigned throughout its lifetime.

When the Scala interpreter (or compiler) can infer types, it is often best to let it do so rather than fill the code with unnecessary, explicit type annotations.

## Functions
Function definitions start with **def**. The function's name, is followed by a comma-separated list of parentheses. A type annotion must follow every function parameter, preceded by a colon, because the Scala compiler does not infer funciton parameter types. After the close parenthesis of parameter list you'll find another type annotation. This one defines the result type of the function itself. Following the function's result type is an equals sign and pair of curly braces that contain the body of the function.

The equals sign that precedes the body of a function hints that in the functional world view, a fucntion defines an expression that results in a value.

Sometimes the Scala compiler will require you to specify the result type of a function. If the function is recursive, for example, you must explicitly specify the function's result type.

If a function consists of just one statement, you can optionally leave off the curly braces.

A result type of **Unit** indicates the function returns no interesting value. Scala's **Unit** type is similar to Java's **void** type, and in fact every void-returning method in Java is mapped to a Unit-returning method in Scala. Methods with the result type of Unit, therefore, are only executed for their side effect.

## Arrays
In Scala, arrays are zero based, and you access an element by specifying an index in parentheses. So the first element in a Scala array named `steps` is `steps(0)`, not `steps[0]`.

Arrays are simply instances of classes like any other class in Scala. When you apply parentheses surrounding one or more values to a variable, Scala will transform the code into an invocation of a method named `apply` on that variable. Thus accessing an element of an array in Scala is simply a method call like any other.

```scala
val numNames = Array("zero", "one", "two")
```

One of the main charateristics of a functional language is that functions are first class constructs, and that's very true in Scala. For example, a far more concise way to print each command line argument is:
```scala
args.foreach(arg => println(arg))
```
In this code, you call the `foreach` method on args, and pass in a function. In this case, you're passing in a *function literal* that takes one parameter named `arg`. The body of the fucntion is `println(arg)`.

```scala
args.foreach((arg: String) => println(arg))
```

```scala
args.foreach(println)
```

To summarize, the syntax for a function literal is a list of named parameters, in parentheses, a right arrow, and the body of the fucntion.

In Scala, you can instantiate objects, or class instance, using **new**.

## Lists
One of the big ideas of the functional sytle of programming is that methods should not have side effects. A method's only act should be to compute and return a value. Applying this functional philosophy to the world of objects means making objects immutable.

For an immutable sequence of objects that share the same type you can use Scala's **List** class. Scala's List, scala.List, differs from Java's java.util.List type in that Scala Lists are always immutable (whereas Java Lists can be mutable). More generally, Scala's List is designed to enable a functional style of programming.

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

## Learn to recognize the functional style
One telltale sign is that if code contains any vars, it is probably in an imperative style. If the code contains no vars at all i.e. it contains only vals, it is probably in a functional style. One way to move towards a functional style, therefore, is to try to program without vars.

The telltale sign of a function with side effects is that its result type is `Unit`.

Every useful program is likely to have side effects of some form, because otherwise it wouldn't be able to provide value to the outside world. Preferring methods without side effects encourages you to design programs where side-effecting code is minimized. One benefit of this approach is that it can help make your programs easier to test.

That said, bear in mind that neither vars nor side effects are inherently evil. Scala is not a pure functional language that forces you to program everything in the functional style. Scala is a hybrid imperative/functional language.

## Traits
Similar to interfaces in Java, traits are used to define object types by specifying the signature of the supported methods. Like in Java 8, Scala allows traits to be partially implemented; i.e. it is possible to define default implementations for some methods. In contrast to classes, traits may not have constructor parameters. Here is an example:
```scala
trait Similarity {
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}
```
This trait consists of two methods `isSimilar` and `isNotSimilar`. While `isSimilar` does not provide a concrete method implementation (it is abstract in the terminology of Java), method `isNotSimilar` defines a concrete implementation. Consequently, classes that integrate this trait only have to provide a concrete implementation for `isSimilar`. The behavior for `isNotSimilar` gets inherited directly from the trait.

# Collections

## Lists

One of the big ideas of the functional style of programming is that methods should not have side effects.
A method's only act should be to compute and return a value.
Applying this functional philosophy to the world of objects means making objects immutable.

For an immutable sequence of objects that share the same type you can use Scala's **List** class.
Scala's List, `scala.List`, differs from Java's `java.util.List` type in that Scala Lists are always immutable (whereas Java Lists can be mutable).
More generally, Scala's List is designed to enable a functional style of programming.

Creating a list is easy:
```scala
val oneTwoThree = List(1, 2, 3)
```

## List Buffers

A `ListBuffer` is a mutable object (contained in package `scala.collection.mutable`), which can help you build lists more efficiently when you need to append.
`ListBuffer` provides constant time append and prepend operations.
You append elements with the `+=` operator, and prepend them with the `+=:` operator.
When you're done building, you can obtain a `List` by invoking `toList` on the `ListBuffer`.

## Mutable and immutable collections

Scala collections systematically distinguish between mutable and immutable collections.

A mutable collection can be updated or extended in place.
This means you can change, add, or remove elements of a collection as a side effect.

Immutable collections, by contrast, never change.
You still have operations that simulate additions, removals, or updates, but those operations will in each case return a new collection and leave the old collection unchanged.

All collection classes are found in the package `scala.collection` or one of its subpackages: `mutable`, `immutable`, and `generic`.
Most collection classes needed by client code exist in three variants, each of which has different characteristics with respect to mutability.
The three variants are located in packages `scala.collection`, `scala.collection.immutable`, and `scala.collection.mutable`.

## Collection consistency

There is quite a bit of commonality shared by all these classes.

All collections support the API provided by `Traversable`, but their methods all return their own class rather than the root class `Traversable`.

## Trait `Traversable`

At the top of the collection hierarchy is trait `Traversable`.
Its only abstract operation is `foreach`:
```scala
def foreach[U](f: Elem => U)
```
Collection classes implementing `Traversable` just need to define this method;
all other methods can be inherited from `Traversable`.

The `foreach` method is meant to traverse all elements of the collection, and apply the given operation, `f`, to each element.
The type of the operation is `Elem => U`, where `Elem` is the type of the collection's elements and `U` is an arbitrary result type.
The invocation of `f` is done for its side effect only; in fact any function result of `f` is discarded by `foreach`.

## Trait `Iterable`

The next trait from the top is `Iterable`.
All methods in this trait are defined in terms of an abstract method, `iterator`, which yields the collection's elements one by one.
The abstract `foreach` method inherited from trait `Traversable` is implemented in `Iterable` in terms of `iterator`.

### Why have both `Traversable` and `Iterable`?

One reason for having `Traversable` is that sometimes it is easier or more efficient to provide an implementation of `foreach` than to provide an implementation of `iterator`.

### Subcategories of `Iterable`

In the inheritance hierarchy below `Iterable` you find three traits: `Seq`, `Set`, and `Map`.
A common aspect of `Seq` and `Map` traits is that they all implement the `PartialFunction` trait with its `apply` and `isDefinedAt` methods.
However, the way each trait implements `PartialFunction` differs.

## The sequence traits `Seq`, `IndexedSeq`, and `LinearSeq`

The `Seq` trait represents sequences.
A sequence is a kind of iterable that has a `length` and whose elements have fixed index positions, starting from `0`.

For a `Seq`, the `apply` operation means indexing;
hence a sequence of type `Seq[T]` is a partial function that take an `Int` argument (an index) and yields a sequence element of type `T`.
In other words `Seq[T]` extends `PartialFunction[Int, T]`.

### Buffers

An important sub-category of mutable sequences is buffers.
Buffers allow not only updates of existing elements but also element insertions, element removals, and efficient additions of new elements at the end of the buffer.

Two `Buffer` implementations that are commonly used are `ListBuffer` and `ArrayBuffer`.

### Sets

`Set`s are `Iterable`s that contain no duplicate elements.

Scala provides mutable and immutable alternatives for sets and maps, but uses the same simple names for both versions.

If you want a mutable set, you'll need to use an *import*:
```scala
import scala.collection.mutable.Set

val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)
```

### Maps

`Map`s are `Iterable`s of pairs of keys and values.

Scala's `Predef` class offers an implicit conversion that lets you write `key -> value` as an alternate syntax for the pair `(key, value)`.

## Concrete immutable collection classes

### Lists

### Streams

### Vectors

### Immutable stacks

### Immutable queues

### Ranges

### Hash tries

## Concrete mutable collection classes

## Arrays

Arrays are a special kind of collection in Scala.
On the one hand, Scala arrays correspond one-to-one to Java arrays.
But at the same time, Scala arrays offer much more than their Java analogues.
First, Scala arrays can be *generic*.
That is, you can have an `Array[T]`, where `T` is a type parameter or abstract type.
Second, Scala arrays are compatible with Scala sequences - you can pass an `Array[T]` where a `Seq[T]` is required.
Finally, Scala arrays also support all sequence operations.

In Scala, arrays are zero based, and you access an element by specifying an index in parentheses.
So the first element in a Scala array named `steps` is `steps(0)`, not `steps[0]`.

Arrays are simply instances of classes like any other class in Scala.
When you apply parentheses surrounding one or more values to a variable, Scala will transform the code into an invocation of a method named `apply` on that variable.
Thus accessing an element of an array in Scala is simply a method call like any other.
```scala
val numNames = Array("zero", "one", "two")
```

## Strings

Like arrays, strings are not directly sequences, but they can be converted to them, and they also support all sequence operations.

## Performance characteristics

## Equality

## Views

A *view* is a special kind of collection that represents some base collection, but implements all of its transformers lazily.

## Iterators

An iterator is not a collection, but rather a way to access the elements of a collection one by one.
The two basic operations on an iterator `it` are `next` and `hasNext`.
A call to `it.next()` will return the next element of the iterator and advance the state of the iterator.
If there are no more elements to return, a call to `next` will throw a `NoSuchElementException`.

When called on an iterator, `foreach` will leave the iterator at its end when it is done.

## Creating collections from scratch

This is actually a universal feature of Scala collections.
You can take any collection name and follow it by a list of elements in parentheses.
The result will be a new collection with the given elements.

Every collection class in Scala library has a companion object with such an `apply` method.
It does not matter whether the collection class represents a concrete implementation, or whether it is an trait such as `Seq`, `Set`, or `Traversable`.

Besides `apply`, every collection companion object also defines a member `empty`, which returns an empty collection.

## The Architecture of Scala Collections

The principal design objective of the collections framework is to avoid any duplication, defining every operation in as few places as possible.
The approach is to implement most operations in "template traits" that can be mixed into individual collection base and implementation classes.

### Factoring out common operations

The main design objective of the collection library is to provide natural types to users while sharing as much implementation code as possible.
In particular, Scala's collection framework needs to support the following aspects of various concrete collection types:
* Some transformation operations return the same concrete collection type.
For example, `filter` on `List[Int]` returns `List[Int]`.
* Some transformation operations return the same concrete collection type with possibly a different type of elements.
For example, `map` on `List[Int]` can return `List[String]`.
* Some collection types, such as `List[A]`, have a single type parameter, whereas others, like `Map[K, v]`, have two.
* Some operations on collection return a different concrete collection depending on an element type.
For example, `map` on `Map` returns another `Map` if the mapping function results in a key-value pair, but otherwise returns an `Iterable`.
* Transformation operations on certain collection types require additional implicit parameters.
For example, `map` on `SortedSet` requires an implicit `Ordering`.
* Lastly, some collections, such as `List`, are strict, while other collections, like `View` and `LazyList`, are non-strict.

The collection framework's template traits abstract over the above list of differences between various collections.
In the rest of this section, you will find out how this is achieved.

#### Abstracting over collection types

The `IterableOps` template trait implements the operations available on the `Iterable[A]` collection type.
`IterableOps` is defined like this:
```scala
trait IterableOps[+A, +CC[_], +C]
```
`IterableOps` declares three type parameters named `A`, `CC`, and `C`.
For an `Iterable` that extends `IterableOps`, `A` defines its element type, `CC` its type constructor, and `C` its complete type.

The Scala collection library avoids code duplication and achieves the "same-result type" principle by using generic builders and traversals over collections in so-called *implementation traits*.
These traits are named with a `Like` suffix.

They parameterize not only over the collection's element type, but also over the collection's *representation* type (i.e., the type of the underlying collection).
For instance, here is the header of trait `TraversableLike`:
```scala
trait TraversableLike[+A, +Repr]
```
The trait declares two abstract methods, `newBuilder` and `foreach`, which are implemented in concrete collection classes.
```scala
protected[this] def newBuilder: Builder[A, Repr]
```

### Integrating new collections

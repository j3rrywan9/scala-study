# Concurrency

Scala's standard library offers an alternative that avoids these difficulties by focusing on asynchronous transformations of immutable state: the `Future`.

By contrast, you can specify transformations on a Scala `Future` whether it has completed or not.
Each transformation results in a new `Future` representing the asynchronous result of the original `Future` transformed by the function.
The thread that performs the computation is determined by an implicitly provided *execution context*.
This allows you to describe asynchronous computations as a series of transformations of immutable values, with no need to reason about shared memory and locks.

## Asynchronous execution and `Try`s

When you invoke a Scala method, it performs a computation "while you wait" and returns a result.
If that result is `Future`, the `Future` represents another computation to be performed asynchronously, often by a completely different thread.
As a result, many operations on `Future` require an implicit *execution context* that provides a strategy for executing functions asynchronously.

Two methods on `Future` allow you to poll: `isCompleted` and `value`.

The option returned by `value` contains a `Try`.
A `Try` is either a `Success`, which contains a value of type `T`, or a `Failure`, which contains an exception (an instance of `java.lang.Throwable`).
The purpose of `Try` is to provide for asynchronous computations what the `try` expression provides for synchronous computations:
It allows you to deal with the possibility that the computation will complete abruptly with an exception rather than a result.

## Working with `Future`

Scala's `Future` allows you to specify transformations on `Future` results and obtain a *new future* that represents the composition of the two asynchronous computations: the original and the transformation.

### Transforming `Future`s with `map`

Instead of blocking then continuing with another computation, you can just `map` the next computation onto the future.
The result will be a new future that represents the original asynchronously computed result transformed asynchronously by the function passed to `map`.

### Transforming `Future`s with `for` expressions

Because Scala's future also declares a `flatMap` method, you can transform futures using a `for` expression.

### Creating the `Future`

Besides the apply method, used in earlier examples to create futures, the `Future` companion object also includes three factory methods for creating already-completed futures: `successful`, `failed`, and `fromTry`.
These factory methods do not require an `ExecutionContext`.

The most general way to create a future is to use a `Promise`.
Given a promise you can obtain a future that is controlled by the promise.
The future will complete when you complete the promise.

### Filtering

Scala's future offers two methods, `filter` and `collect`, that allow you to ensure a property holds true about a future value.

The `filter` method validates the future result, leaving it the same if it is valid.
If the future value is not valid, the future returned by `filter` will fail with a `NoSuchElementException`.

`Future`'s `collect` method allows you to validate the future value and transform it in one operation.
If the partial function returned by `collect` is defined at the future result, the future returned by `collect` will succeed with that value transformed by the function.
Otherwise, the future will fail with `NoSuchElementException`.

### Dealing with failure

Scala's future provides ways to work with futures that fail, including `failed`, `fallBackTo`, `recover`, and `recoverWith`.

The `failed` method will transform a failed future of any type into a successful `Future[Throwable]` that holds onto the exception that caused the failure.

The `fallbackTo` method allows you to provide an alternate future to use in case the future on which you invoke `fallbackTo` fails.

### Mapping both possibilities

`Future`'s `transform` method accepts two functions with which to transform a future:
one to use in case of success and the other in case of failure.

### Combining futures

### Performing side-effects

Sometimes you may ned to perform a side effect after a future completes.
`Future` provides several methods for this purpose.
The most basic method is `foreach`, which will perform a side effect if a future completes successfully.

`Future` also offers two methods for registering "callback" functions.

The `onComplete` method will be executed whether the future ultimately succeeds or fails.
The function will be passed a `Try` - a `Success` holding the result if the future succeeded, else a `Failure` holding the exception that caused the future to fail.

## Testing with `Future`s

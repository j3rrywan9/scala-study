# Functional Programming in Scala

## Chapter 1

Functional programming (FP) is based on a simple premise with far-reaching implications: we construct our programs using only *pure functions* — in other words, functions that have no *side effects*.

### The benefits of FP

### Exactly what is a (pure) function?

A function `f` with input type `A` and output type `B` (written in Scala as a single type: `A => B`, pronounced "A to B" or "A arrow B") is a computation that relates every value `a` of type `A` to exactly one value `b` of type `B` such that `b` is determined solely by the value of `a`.
Any changing state of an internal or external process is irrelevant to computing the result `f(a)`.

In other words, a function has no observable effect on the execution of the program other than to compute a result given its inputs; we say that it has no side effects.

We sometimes qualify such functions as *pure* functions to make this more explicit, but this is somewhat redundant.
Unless we state otherwise, we'll often use *function* to imply no side effects.

We can formalize this idea of pure functions using the concept of *referential transparency (RT)*.
This is a property of *expressions* in general and not just functions.

This is all it means for an expression to be referentially transparent — in any program, the expression can be replaced by its result without changing the meaning of the program.
And we say that a function is *pure* if calling it with RT arguments is also RT.

#### Referential transparency and purity

An expression e is *referentially transparent* if, for all programs `p`, all occurrences of `e` in `p` can be replaced by the result of evaluating `e` without affecting the meaning of `p`.
A function `f` is pure if the expression `f(x)` is referentially transparent for all referentially transparent `x`.

### RT, purity, and the substitution model

Referential transparency forces the invariant that everything a function *does* is represented by the *value* that it returns, according to the result type of the function.
This constraint enables a simple and natural mode of reasoning about program evaluation called the *substitution model*.

## Chapter 2

## Chapter 3

### Defining functional data structures

### Pattern matching

## Chapter 4

The big idea is that we can represent failures and exceptions with ordinary values, and we can write higher-order functions that abstract out common patterns of error handling and recovery.
The functional solution, of returning errors as values, is safer and retains referential transparency, and through the use of higher-order functions, we can preserve the primary benefit of exceptions — *consolidation of error-handling logic*.

### The good and bad aspects of exceptions

The technique we use is based on an old idea: instead of throwing an exception, we return a value indicating that an exceptional condition has occurred.
But instead of using error codes, we introduce a new generic type for these "possibly defined values" and use higher-order functions to encapsulate common patterns of handling and propagating errors.

### The `Option` data type

The solution is to represent explicitly in the return type that a function may not always have an answer.
We can think of this as deferring to the caller for the error-handling strategy.

#### Usage patterns for `Option`

##### Basic functions on `Option`

`Option` can be thought of like a `List` that can contain at most one element, and many of the `List` functions we saw earlier have analogous functions on `Option`.

### The `Either` data type

## Chapter 5

### Strict and non-strict functions

Non-strictness is a property of a function.
To say a function is non-strict just means that the function may choose *not* to evaluate one or more of its arguments.
In contrast, a *strict* function always evaluates its arguments.
Strict functions are the norm in most programming languages, and indeed most languages only support functions that expect their arguments fully evaluated.
Unless we tell it otherwise, any function definition in Scala will be strict (and all the functions we've defined so far have been strict).

In Scala, we can write non-strict functions by accepting some of our arguments unevaluated.

### Separating program description from evaluation

A major theme in functional programming is *separation of concerns*.
We want to separate the description of computations from actually running them.

More generally speaking, laziness lets us separate the description of an expression from the evaluation of that expression.
This gives us a powerful ability — we may choose to describe a "larger" expression than we need, and then evaluate only a portion of it.

## Chapter 6

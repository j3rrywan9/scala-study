# Extractors

Sometimes you might wish that you could write patterns like this without creating an associated case class.
In fact, you might wish to be able to create your own kinds of patterns.
Extractors give you a way to do so.

An extractor in Scala is an object that has a method called `unapply` as one of its members.
The purpose of that `unapply` method is to match a value and take it apart.
Often, the extractor object also defines a dual method `apply` for building values, but this is not required.

Now, whenever pattern matching encounters a pattern referring to an extractor object, it invokes the extractor's `unapply` method on the selector expression.

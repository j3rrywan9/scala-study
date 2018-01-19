# Regular Expressions

One particularly useful application area of extractors are regular expressions.
Like Java, Scala provides regular expressions through a library, but extractors make it much nicer to interact with them.

## Forming regular expressions

Scala's regular expression class resides in package `scala.util.matching`.

A new regular expression value is created by passing a string to the `Regex` constructor.

In other word, simply append a `.r` to a string to obtain a regular expression.
This is possible because there is a method named `r` in the class `StringOps`, which converts a string to a regular expression.

## Searching for regular expressions

## Extracting with regular expressions

What's more, every regular expression in Scala defines an extractor.
The extractor is used to identify substrings that are matched by the groups of the regular expression.

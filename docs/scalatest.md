# ScalaTest

## Getting started

The central concept in ScalaTest is the *suite*, a collection of zero to many tests.

A *test* can be anything with a name that can start and either succeed, fail, be pending, or canceled.

## Selecting testing styles

ScalaTest supports different styles of testing, each designed to address a particular set of needs.

### Style trait use cases

#### `FunSpec`

## Running your tests

### Using the ScalaTest Maven plugin

The ScalaTest Maven plugin allows you to run ScalaTest tests through Maven without requiring `@RunWith(classOf[JUnitRunner])` annotations and access all functionality of the ScalaTest `Runner`, including parallel execution and multiple reporters.

To use the ScalaTest Maven plugin, you need to disable SureFire and enable ScalaTest.

## Using matchers

ScalaTest provides a domain specific language (DSL) for expressing assertions in tests using the word `should`.
Just mix in `Matchers`, like this:
```scala
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {
}
```

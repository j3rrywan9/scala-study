# ScalaTest

## Getting started

First a brief orientation:
* The central concept in ScalaTest is the *suite*, a collection of zero to many tests.
* A *test* can be anything with a name that can start and either succeed, fail, be pending, or canceled.
* The central unit of composition in ScalaTest is `Suite`, which represents a suite of tests.
* Trait `Suite` declares run and other "lifecycle" methods that define a default way to write and run tests.
* These lifecycle methods can be overridden to customize how tests are written and run.
* ScalaTest offers *style traits* that extend `Suite` and override lifecycle methods to support different testing styles.
* It provides *mixin traits* that override lifecycle methods of the style traits to address particular testing needs.
* You define test classes by composing `Suite` style and mixin traits.
* You define test suites by composing `Suite` instances.

## Selecting testing styles

ScalaTest supports different styles of testing, each designed to address a particular set of needs.

We recommend you choose a set of testing styles for each project, then encourage everyone working on the project use the chosen styles.
This allows the testing styles to fit the team while maintaining uniformity in the project code base.
We recommend you select one main style for unit testing and another for acceptance testing.
Using a different style for unit and acceptance testing can help developers "switch gears" between low-level unit testing to high-level acceptance testing.

### Style trait use cases

#### `FunSpec`

For teams coming from Ruby's RSpec tool, FunSpec will feel very familiar; More generally, for any team that prefers BDD, FunSpec's nesting and gentle guide to structuring text (with `describe` and `it`) provides an excellent general-purpose choice for writing specification-style tests.
```scala
import org.scalatest.FunSpec

class SetSpec extends FunSpec {

  describe("A Set") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size == 0)
      }

      it("should produce NoSuchElementException when head is invoked") {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
```

#### `PropSpec`

PropSpec is perfect for teams that want to write tests exclusively in terms of property checks; also a good choice for writing the occasional test matrix when a different style trait is chosen as the main unit testing style.

## Running your tests

### Using the ScalaTest Maven plugin

The ScalaTest Maven plugin allows you to run ScalaTest tests through Maven without requiring `@RunWith(classOf[JUnitRunner])` annotations and access all functionality of the ScalaTest `Runner`, including parallel execution and multiple reporters.

To use the ScalaTest Maven plugin, you need to disable SureFire and enable ScalaTest.
Here's an example of how to do this in your `pom.xml`:
```xml
<!-- disable surefire -->
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>2.20</version>
  <configuration>
    <skipTests>true</skipTests>
  </configuration>
</plugin>

<!-- enable scalatest -->
<plugin>
  <groupId>org.scalatest</groupId>
  <artifactId>scalatest-maven-plugin</artifactId>
  <version>2.0.0</version>
  <configuration>
    <reportsDirectory>${project.build.directory}/surefire-reports</reportsDirectory>
    <junitxml>.</junitxml>
    <filereports>WDF TestSuite.txt</filereports>
  </configuration>
  <executions>
    <execution>
      <id>test</id>
      <goals>
        <goal>test</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

## Using matchers

ScalaTest provides a domain specific language (DSL) for expressing assertions in tests using the word `should`.
Just mix in `Matchers`, like this:
```scala
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {
}
```

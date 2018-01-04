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

# Gatling

Gatling is a powerful open-source load testing solution.

## Installation

### Using a Build Tool

#### Maven

Gatling provides an official maven plugin named *gatling-maven-plugin*.
This plugin lets you compile your Scala code and launch Gatling simulations.

##### Maven plugin

###### Versions

###### Setup

In your `pom.xml`, add:
```xml
<dependencies>
  <dependency>
    <groupId>io.gatling.highcharts</groupId>
    <artifactId>gatling-charts-highcharts</artifactId>
    <version>MANUALLY_REPLACE_WITH_LATEST_VERSION</version>
    <scope>test</scope>
  </dependency>
</dependencies>

<plugin>
  <groupId>io.gatling</groupId>
  <artifactId>gatling-maven-plugin</artifactId>
  <version>MANUALLY_REPLACE_WITH_LATEST_VERSION</version>
</plugin>
```

###### Usage

```bash
mvn gatling:help -Ddetail=true -Dgoal=test

mvn clean package gatling:test
```

## General

### Scenario

#### Bootstrapping

#### Structure elements

##### exec

The `exec` method is used to execute an action.

`exec` can also be passed an `Expression` function.

This can be used for manually debugging or editing the `Session`, e.g.:
```scala
exec { session =>
  // displays the content of the session in the console (debugging only)
  println(session)
  
  // returns the original session
  session
}

exec { session =>
  // return a new session instance with a new "foo" attribute whose value is "bar"
  session.set("foo", "bar")
}
```

##### pause

## HTTP

### HTTP Protocol

#### Bootstrapping

Use the `http` object in order to create an HTTP protocol.

#### Core parameters

##### Base URL

#### Engine parameters

#### Request building parameters

##### Automatic Referer

The `Referer` HTTP header can be automatically computed.
This feature is enabled by default.

To disable this feature, just add `.disableAutoReferer` to an HTTP Protocol Configuration definition.

#### Response handling parameters

##### Follow redirects

By default Gatling automatically follow redirects in case of 301, 302, 303 or 307 response status code, you can disable this behavior with `.disableFollowRedirect`.

## Code Reading

```scala
package io.gatling.core.session

case class Session extends LazyLogging
```

```scala
package io.gatling.commons.validation

sealed trait Validation[@specialized(Short, Int, Long, Double, Char, Boolean) +T]

case class Success[+T](value: T) extends Validation[T]

case class Failure(message: String) extends Validation[Nothing]
```

```scala
package io.gatling.core

package object session {
  type Expression[T] = Session => Validation[T]
}
```

```scala
package io.gatling.core.structure

private[structure] trait Execs[B] {

  protected def actionBuilders: List[ActionBuilder]
  protected def chain(newActionBuilders: Seq[ActionBuilder]): B

  def exec(sessionFunction: Expression[Session]): B = exec(new SessionHookBuilder(sessionFunction, exitable = true))
  def exec(actionBuilder: ActionBuilder): B = chain(List(actionBuilder))
}
```

```scala
package io.gatling.core.action.builder

trait ActionBuilder {
  def build(ctx: ScenarioContext, next: Action): Action
}

class SessionHookBuilder(sessionFunction: Expression[Session], exitable: Boolean) extends ActionBuilder with NameGen
```

```scala
package io.gatling.http.cookie

import io.netty.handler.codec.http.cookie.Cookie

case class StoredCookie(cookie: Cookie, hostOnly: Boolean, persistent: Boolean, creationTime: Long)

case class CookieJar(store: Map[CookieKey, StoredCookie])
```

## References

[Gatling Documentation](https://gatling.io/docs/current/)

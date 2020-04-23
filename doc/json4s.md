# json4s

This project aims to provide a single AST to be used by other Scala JSON libraries.

## Guide

A central concept in lift-json library is Json AST which models the structure of a JSON document as a syntax tree.
```scala
sealed abstract class JValue
case object JNothing extends JValue // 'zero' for JValue
case object JNull extends JValue
case class JString(s: String) extends JValue
case class JDouble(num: Double) extends JValue
case class JDecimal(num: BigDecimal) extends JValue
case class JInt(num: BigInt) extends JValue
case class JLong(num: Long) extends JValue
case class JBool(value: Boolean) extends JValue
case class JObject(obj: List[JField]) extends JValue
case class JArray(arr: List[JValue]) extends JValue

type JField = (String, JValue)
```
All features are implemented in terms of the above AST.
Functions are used to transform the AST itself, or to transform the AST between different formats.

## DSL rules

* Primitive types map into JSON primitives.
* Any `Seq` produces JSON array.
* `Tuple2[String, A]` produces fields.
* `~` operator produces object by combining fields.
```scala
scala> val json = ("name" -> "joe") ~ ("age" -> 35)

scala> compact(render(json))
res2: String = {"name":"joe","age":35}
```
* Any value can be optional.
The field and value are completely removed when it doesn't have a value.

## Serialization

Case classes can be serialized and deserialized.

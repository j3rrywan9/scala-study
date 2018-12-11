# Scala Design Patterns

## Preface

Using Scala to its full potential, however, requires us to be familiar with not only the object-oriented features, but also with the functional ones.

The fact that Scala is close to object-oriented languages means that many of the design patterns for object-oriented programming are still applicable here.
The fact that it is also functional means that some other design patterns are also applicable, and some of the object-oriented ones could be modified to better fit the paradigm of Scala.

## Traits and Mixin Compositions

### Traits

#### Traits as interface

Traits can be viewed as interfaces in other languages, for example, Java.
However they, allow the developers to implement some or all of their methods.
Whenever there is some code in a trait, the trait is called a **mixin**.
```scala
trait Alarm {
  def trigger(): String
}
```

```scala
trait Notifier {
  val notificationMessage: String
  
  def printNotification(): Unit = {
    System.out.println(notificationMessage)
  }
}
```

#### Mixing in traits with variables

As we just pointed out, traits might require a class to have a specific variable.
An interesting use case would be when we pass a variable to the constructor of a class.
This will cover the trait requirements:
```scala
class NotifierImpl(val notificationMessage: String) extends Notifer {
  override def clear(): Unit = System.out.println("cleared")
}
```
The only requirement here is for the variable to have the same name and to be preceded by the `val` keyword in the class definition.
The reason for this behavior is simple: if we explicitly use `val` (or `var`), the compiler will create a field with a getter with the same scope as the parameter.
For completeness, case classes automatically have the `val` keyword *prepended* to parameters. 

#### Traits as classes

Traits can also be seen from the perspective of classes.
In this case, they have to implement all their methods and have only one constructor that does not accept any parameters.

#### Extending classes

It is possible for traits to extend classes.

#### Extending traits

Traits can also extend each other.

### Mixin compositions

Scala allows developers to extend many traits in a single class.
This adds the possibility of achieving multiple inheritance and saves a lot of effort in code writing, which has to be performed in languages where extending many classes is not allowed.

#### Mixing traits in

#### Composing

Composing at creation time gives us an opportunity to create anonymous classes without the need to explicitly define them.

##### Composing simple traits

##### Composing complex traits

##### Composing with self-types

```scala
trait AlarmNotifier {
  this: Notifier =>
  
  def trigger(): String
}
```
In the preceding code, we've shown a **self-type*.
The highlighted piece of code brings all the methods of `Notifier` to the scope of our new trait and it also requires that any class that mixes in `AlarmNotifier` should also mix in `Notifier`.
Otherwise, a compilation error will occur.

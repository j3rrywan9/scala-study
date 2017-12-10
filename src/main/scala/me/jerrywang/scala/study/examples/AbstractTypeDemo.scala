package me.jerrywang.scala.study.examples

object AbstractTypeDemo extends App {
  class Food

  abstract class Animal {
    /**
      * Abstract type with upper bound.
      */
    type SuitableFood <: Food
    def eat(food: SuitableFood)
  }

  class Grass extends Food

  class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) = {}
  }

  val bessy = new Cow
  bessy.eat(new Grass)

  class Fish extends Food

  /**
    * Compilation error.
    */
  // bessy.eat(new Fish)

  class DogFood extends Food

  class Dog extends Animal {
    type SuitableFood = DogFood
    override def eat(food: SuitableFood) = {}
  }

  val lassie = new Dog
  /**
    * Compilation error.
    */
  // lassie.eat(new bessy.SuitableFood)
  val bootsie = new Dog
  lassie.eat(new bootsie.SuitableFood)
}

package me.jerrywang.scala.study.algorithms

import org.scalacheck.Gen
import org.scalatest.Matchers._
import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks

import me.jerrywang.scala.study.algorithms.interview.LookAndSay

class LookAndSaySpec extends PropSpec with PropertyChecks {
  val randomSeed = Gen.choose(0, Int.MaxValue)
  val iterationLessThanOne = Gen.choose(Int.MinValue, 0)

  property("the encode method must handle less than 1 iterations") {
    forAll(randomSeed, iterationLessThanOne) { (seed, iteration) =>
      val output = LookAndSay.encode(seed, iteration)
      output should be (seed.toString)
    }
  }
}

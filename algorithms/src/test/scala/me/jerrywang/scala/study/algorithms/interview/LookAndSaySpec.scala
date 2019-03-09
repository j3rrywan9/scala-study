package me.jerrywang.scala.study.algorithms.interview

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{ Matchers, PropSpec }

class LookAndSaySpec extends PropSpec with PropertyChecks with Matchers {
  val randomSeed = Gen.choose(0, Int.MaxValue)
  val iterationLessThanOne = Gen.choose(Int.MinValue, 0)

  property("the encode method must handle less than 1 iterations") {
    forAll(randomSeed, iterationLessThanOne) { (seed, iteration) =>
      val output = LookAndSay.encode(seed, iteration)
      output should be(seed.toString)
    }
  }
}

package me.jerrywang.scala.study.algorithms.interview

import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class LookAndSaySpec extends AnyPropSpec with ScalaCheckDrivenPropertyChecks with Matchers {
  val randomSeed: Gen[Int] = Gen.choose(0, Int.MaxValue)
  val iterationLessThanOne: Gen[Int] = Gen.choose(Int.MinValue, 0)

  property("the encode method must handle less than 1 iterations") {
    forAll(randomSeed, iterationLessThanOne) { (seed, iteration) =>
      val output = LookAndSay.encode(seed, iteration)
      output should be(seed.toString)
    }
  }
}

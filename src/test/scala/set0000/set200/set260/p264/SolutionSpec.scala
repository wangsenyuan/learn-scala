package set0000.set200.set260.p264

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "10-th ugly number" should "be 12" in {
    Solution.nthUglyNumber(10) should be(12)
  }
}

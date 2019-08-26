package set0000.set800.set870.p875

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minEatingSpeed(Array(30, 11, 23, 4, 20), 5)
    res should be(30)
  }
}

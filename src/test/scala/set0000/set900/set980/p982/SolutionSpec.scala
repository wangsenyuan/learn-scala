package set0000.set900.set980.p982

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.countTriplets(Array(2, 1, 3))
    res should be(12)
  }
}

package set1000.set1200.set1200.p1201

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.nthUglyNumber(4, 2, 3, 4)
    res should be(6)
  }
}

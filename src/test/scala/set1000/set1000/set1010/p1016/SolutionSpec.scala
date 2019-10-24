package set1000.set1000.set1010.p1016

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.queryString("0110", 3)
    res should be(true)
  }
}

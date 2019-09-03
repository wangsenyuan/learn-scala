package set0000.set900.set900.p906

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.superpalindromesInRange("4", "1000")
    res should be(4)
  }
}

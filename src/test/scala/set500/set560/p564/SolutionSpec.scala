package set500.set560.p564

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.nearestPalindromic("1")
    res should equal("0")
  }
}

package set800.set800.p808

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.soupServings(3275)
    (res - 0.99987).abs should be < 1e-6
  }
}

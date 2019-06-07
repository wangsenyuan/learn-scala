package set700.set740.p740

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.deleteAndEarn(Array(4, 10, 10, 8, 1, 4, 10, 9, 7, 6))
    res should be(53)
  }
}

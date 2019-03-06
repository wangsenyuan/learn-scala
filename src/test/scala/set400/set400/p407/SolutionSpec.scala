package set400.set400.p407

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val hm = Array(
      Array(1, 4, 3, 1, 3, 2),
      Array(3, 2, 1, 3, 2, 4),
      Array(2, 3, 3, 2, 3, 1),
    )
    val res = Solution.trapRainWater(hm)
    res should be(4)
  }
}

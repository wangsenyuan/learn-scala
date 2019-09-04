package set0000.set900.set900.p907

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.sumSubarrayMins(Array(3, 1, 2, 4))
    res should be(17)
  }
}

package set0000.set900.set920.p927

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.threeEqualParts(Array(1, 0, 1, 0, 1))
    res should be(Array(0, 3))
  }
}

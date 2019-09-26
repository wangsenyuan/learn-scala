package set0000.set900.set960.p962

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.maxWidthRamp(Array(3, 28, 15, 1, 4, 12, 6, 19, 8, 15, 3, 9, 6, 4, 13, 12, 6, 12, 10, 1, 2, 1, 4, 1, 4, 0, 0, 1, 1, 0)) should be(25)
  }
}

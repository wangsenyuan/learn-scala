package set0000.set900.set950.p954

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(4, -2, 2, -4)
    Solution.canReorderDoubled(arr) should be(true)
  }
}

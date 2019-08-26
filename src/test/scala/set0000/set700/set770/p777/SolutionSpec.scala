package set0000.set700.set770.p777

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val start = "RXXLRXRXL"
    val end = "XRLXXRRLX"
    val res = Solution.canTransform(start, end)
    res should be(true)
  }

  "example two" should "work" in {
    val start = "RL"
    val end = "LR"
    val res = Solution.canTransform(start, end)
    res should be(false)
  }
}

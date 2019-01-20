package set200.set240.p241

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2-1-1" should "get [0, 2]" in {
    val res = Solution.diffWaysToCompute("2-1-1")
    res.sorted should equal(List(0, 2))
  }

  "2*3-4*5" should "get [-34, -14, -10, -10, 10]" in {
    val res = Solution.diffWaysToCompute("2*3-4*5")
    res.sorted should equal(List(-34, -14, -10, -10, 10))
  }
}

package set1000.set1100.set1180.p1186

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(1, -2, 0, 3)
    val res = Solution.maximumSum(arr)
    res should be(4)
  }
}

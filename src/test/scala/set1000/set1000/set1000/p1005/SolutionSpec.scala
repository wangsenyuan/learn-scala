package set1000.set1000.set1000.p1005

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(5, 6, 9, -3, 3)
    val K = 2
    val res = Solution.largestSumAfterKNegations(arr, K)
    res should be(20)
  }
}

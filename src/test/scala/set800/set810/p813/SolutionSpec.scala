package set800.set810.p813

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(9, 1, 2, 3, 9)
    val K = 3
    val res = Solution.largestSumOfAverages(arr, K)
    (res - 20).abs should be < 1e-6
  }

  "example two" should "work" in {
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    val K = 4
    val res = Solution.largestSumOfAverages(arr, K)
    (res - 20.5).abs should be < 1e-6
  }
}

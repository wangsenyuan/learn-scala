package set1000.set1000.set1000.p1004

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
    val K = 2
    val res = Solution.longestOnes(A, K)
    res should be(6)
  }

  "example two" should "work" in {
    val A = Array(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
    val K = 3
    val res = Solution.longestOnes(A, K)
    res should be(10)
  }
}

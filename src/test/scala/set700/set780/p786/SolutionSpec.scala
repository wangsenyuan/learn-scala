package set700.set780.p786

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array(1, 2, 3, 5)
    val K = 3
    val res = Solution.kthSmallestPrimeFraction(A, K)
    res should equal(Array(2, 5))
  }
  "example two" should "work" in {
    val A = Array(1, 7)
    val K = 1
    val res = Solution.kthSmallestPrimeFraction(A, K)
    res should equal(Array(1, 7))
  }

  "example three" should "work" in {
    val A = Array(1, 7, 23, 29, 47)
    val K = 8
    val res = Solution.kthSmallestPrimeFraction(A, K)
    res should equal(Array(23,47))
  }
}

package set0000.set800.set860.p862

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array(1)
    val K = 1
    val res = Solution.shortestSubarray(A, K)
    res should be(1)
  }

  "example two" should "work" in {
    val A = Array(1, 2)
    val K = 4
    val res = Solution.shortestSubarray(A, K)
    res should be(-1)
  }

  "example three" should "work" in {
    val A = Array(2, -1, 2)
    val K = 3
    val res = Solution.shortestSubarray(A, K)
    res should be(3)
  }

  "example four" should "work" in {
    val A = Array(17, 85, 93, -45, -21)
    val K = 150
    val res = Solution.shortestSubarray(A, K)
    res should be(2)
  }
}

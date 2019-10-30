package set1000.set1000.set1040.p1043

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.maxSumAfterPartitioning(Array(1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3), 4)
    res should be(83)
  }

  "example two" should "work" in {
    val res = Solution.maxSumAfterPartitioning(Array(1, 15, 7, 9, 2, 5, 10), 3)
    res should be(84)
  }
}

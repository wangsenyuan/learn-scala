package set300.set370.p378

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val matrix = Array(Array(1, 5, 9),
      Array(10, 11, 13),
      Array(12, 13, 15))
    val res = Solution.kthSmallest(matrix, 8)
    res should be(13)
  }

  "example two" should "work" in {
    val matrix = Array(Array(1, 3, 5),
      Array(6, 7, 12),
      Array(11, 11, 14))
    val res = Solution.kthSmallest(matrix, 6)
    res should be(11)
  }
}

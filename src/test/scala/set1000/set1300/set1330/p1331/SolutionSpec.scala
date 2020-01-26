package set1000.set1300.set1330.p1331

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.arrayRankTransform(Array(40, 10, 20, 30))
    res should be(Array(4, 1, 2, 3))
  }

  "example two" should "work" in {
    val res = Solution.arrayRankTransform(Array(100, 100, 100))
    res should be(Array(1, 1, 1))
  }

  "example three" should "work" in {
    val res = Solution.arrayRankTransform(Array(37, 12, 28, 9, 100, 56, 80, 5, 12))
    res should be(Array(5, 3, 4, 2, 8, 6, 7, 1, 3))
  }
}

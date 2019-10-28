package set1000.set1000.set1030.p1039

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.minScoreTriangulation(Array(3, 7, 4, 5))
    res should be(144)
  }

  "example two" should "work" in {
    val res = Solution.minScoreTriangulation(Array(1, 3, 1, 4, 1, 5))
    res should be(13)
  }

  "example three" should "work" in {
    val res = Solution.minScoreTriangulation(Array(35, 73, 90, 27, 71, 80, 21, 33, 33, 13, 48, 12, 68, 70, 80, 36, 66, 3, 70, 58))
    res should be(140295)
  }
}

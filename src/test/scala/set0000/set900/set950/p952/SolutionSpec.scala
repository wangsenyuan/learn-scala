package set0000.set900.set950.p952

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.largestComponentSize(Array(4, 6, 15, 35)) should be(4)
  }

  "example two" should "work" in {
    Solution.largestComponentSize(Array(20, 50, 9, 63)) should be(2)
  }

  "example three" should "work" in {
    Solution.largestComponentSize(Array(2, 3, 6, 7, 4, 12, 21, 39)) should be(8)
  }

  "example four" should "work" in {
    Solution.largestComponentSize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)) should be(6)
  }
}

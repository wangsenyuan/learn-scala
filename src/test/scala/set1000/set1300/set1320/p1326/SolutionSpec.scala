package set1000.set1300.set1320.p1326

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val n = 5
    val ranges = Array(3, 4, 1, 1, 0, 0)
    val res = Solution.minTaps(n, ranges)
    res should be(1)
  }

  "example two" should "work" in {
    val n = 3
    val ranges = Array(0, 0, 0, 0)
    val res = Solution.minTaps(n, ranges)
    res should be(-1)
  }

  "example three" should "work" in {
    val n = 7
    val ranges = Array(1, 2, 1, 0, 2, 1, 0, 1)
    val res = Solution.minTaps(n, ranges)
    res should be(3)
  }

  "example four" should "work" in {
    val n = 8
    val ranges = Array(4, 0, 0, 0, 0, 0, 0, 0, 4)
    val res = Solution.minTaps(n, ranges)
    res should be(2)
  }

  "example five" should "work" in {
    val n = 8
    val ranges = Array(4, 0, 0, 0, 4, 0, 0, 0, 4)
    val res = Solution.minTaps(n, ranges)
    res should be(1)
  }

  "example six" should "work" in {
    val n = 17
    val ranges = Array(0, 3, 3, 2, 2, 4, 2, 1, 5, 1, 0, 1, 2, 3, 0, 3, 1, 1)
    val res = Solution.minTaps(n, ranges)
    res should be(3)
  }

  "example seven" should "work" in {
    val n = 25
    val ranges = Array(3, 0, 1, 5, 4, 1, 4, 2, 4, 4, 3, 3, 3, 0, 3, 2, 5, 1, 5, 5, 2, 3, 1, 0, 2, 4)
    val res = Solution.minTaps(n, ranges)
    res should be(4)
  }
}

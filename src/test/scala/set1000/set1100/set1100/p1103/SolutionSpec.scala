package set1000.set1100.set1100.p1103

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val candies = 7
    val n = 4
    val res = Solution.distributeCandies(candies, n)
    res should be(Array(1, 2, 3, 1))
  }

  "example two" should "work" in {
    val candies = 10
    val n = 3
    val res = Solution.distributeCandies(candies, n)
    res should be(Array(5, 2, 3))
  }

  "example three" should "work" in {
    val candies = 60
    val n = 4
    val res = Solution.distributeCandies(candies, n)
    res should be(Array(15, 18, 15, 12))
  }
}

package set1000.set1300.set1350.p1354

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.isPossible(Array(9, 3, 5))
    res should be(true)
  }

  "example two" should "work" in {
    val res = Solution.isPossible(Array(1, 1, 1, 6, 11, 16))
    res should be(false)
  }

  "example three" should "work" in {
    val res = Solution.isPossible(Array(1, 1000000000))
    res should be(true)
  }
}

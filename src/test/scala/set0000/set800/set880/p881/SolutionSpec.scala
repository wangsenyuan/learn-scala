package set0000.set800.set880.p881

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numRescueBoats(Array(3, 2, 3, 2, 2), 6)
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.numRescueBoats(Array(24, 35, 22, 16, 37, 45, 46, 32, 19, 49, 32, 4, 5, 38, 4, 1, 20, 26, 23, 25, 30, 34, 22, 19, 50, 14, 39, 22, 18, 4, 44, 36, 46, 23, 34, 6, 20, 11, 3, 48, 11, 8, 10, 19, 28, 8, 50, 50, 8, 21), 50)
    res should be(27)
  }
}

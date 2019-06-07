package set700.set730.p738

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.monotoneIncreasingDigits(10)
    res should be(9)
  }

  "example two" should "work" in {
    val res = Solution.monotoneIncreasingDigits(1234)
    res should be(1234)
  }

  "example three" should "work" in {
    val res = Solution.monotoneIncreasingDigits(332)
    res should be(299)
  }
}

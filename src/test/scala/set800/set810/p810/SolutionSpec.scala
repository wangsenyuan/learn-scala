package set800.set810.p810

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 1, 2)
    val res = Solution.xorGame(nums)
    res should be(false)
  }

  "example two" should "work" in {
    val nums = Array(1, 0)
    val res = Solution.xorGame(nums)
    res should be(true)
  }
}

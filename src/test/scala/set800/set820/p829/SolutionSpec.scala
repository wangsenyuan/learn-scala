package set800.set820.p829

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.consecutiveNumbersSum(5)
    res should be(2)
  }

  "example two" should "work" in {
    val res = Solution.consecutiveNumbersSum(9)
    res should be(3)
  }

  "example three" should "work" in {
    val res = Solution.consecutiveNumbersSum(15)
    res should be(4)
  }
}

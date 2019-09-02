package set0000.set900.set900.p902

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.atMostNGivenDigitSet(Array("1", "3", "5", "7"), 100)
    res should be(20)
  }

  "example two" should "work" in {
    val res = Solution.atMostNGivenDigitSet(Array("1", "4", "9"), 1000000000)
    res should be(29523)
  }
}

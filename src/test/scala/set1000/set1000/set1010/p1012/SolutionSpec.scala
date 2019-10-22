package set1000.set1000.set1010.p1012

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numDupDigitsAtMostN(100)
    res should be(10)
  }

  "example two" should "work" in {
    val res = Solution.numDupDigitsAtMostN(1000)
    res should be(262)
  }

  "example three" should "work" in {
    val res = Solution.numDupDigitsAtMostN(11)
    res should be(1)
  }
}

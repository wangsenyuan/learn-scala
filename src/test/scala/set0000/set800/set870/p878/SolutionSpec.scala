package set0000.set800.set870.p878

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.nthMagicalNumber(1, 2, 3)
    res should be(2)
  }

  "example two" should "work" in {
    val res = Solution.nthMagicalNumber(4, 2, 3)
    res should be(6)
  }

  "example three" should "work" in {
    val res = Solution.nthMagicalNumber(5, 2, 4)
    res should be(10)
  }

  "example four" should "work" in {
    val res = Solution.nthMagicalNumber(3, 6, 4)
    res should be(8)
  }

  "example five" should "work" in {
    val res = Solution.nthMagicalNumber(4, 4, 6)
    res should be(12)
  }

  "example six" should "work" in {
    val res = Solution.nthMagicalNumber(5, 4, 6)
    res should be(16)
  }

  "example seven" should "work" in {
    val res = Solution.nthMagicalNumber(1000000000, 40000, 40000)
    res should be(999720007)
  }
}


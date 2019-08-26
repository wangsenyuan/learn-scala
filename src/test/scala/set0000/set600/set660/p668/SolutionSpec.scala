package set0000.set600.set660.p668

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.findKthNumber(3, 3, 5)
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.findKthNumber(2, 3, 6)
    res should be(6)
  }

  "example three" should "work" in {
    val res = Solution.findKthNumber(3, 3, 7)
    res should be(6)
  }

  "example four" should "work" in {
    val res = Solution.findKthNumber(3, 3, 8)
    res should be(6)
  }

  "example five" should "work" in {
    val res = Solution.findKthNumber(45, 12, 471)
    res should be(312)
  }
}

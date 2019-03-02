package set400.set400.p400

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "11-st digit" should "be 0" in {
    val res = Solution.findNthDigit(11)
    res should be(0)
  }

  "10-th digit" should "be 1" in {
    val res = Solution.findNthDigit(10)
    res should be(1)
  }

  "12-nd digit" should "be 1" in {
    val res = Solution.findNthDigit(12)
    res should be(1)
  }

  "13-th digit" should "be 1" in {
    val res = Solution.findNthDigit(13)
    res should be(1)
  }

  "15-th digit" should "be 2" in {
    val res = Solution.findNthDigit(15)
    res should be(2)
  }

  "190-th digit" should "be 1" in {
    val res = Solution.findNthDigit(190)
    res should be(1)
  }

  "1000000000-th digit" should "be 1" in {
    val res = Solution.findNthDigit(1000000000)
    res should be(1)
  }
}

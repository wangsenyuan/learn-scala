package set200.set270.p273

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "123" should "get One Hundred Twenty Three" in {
    val res = Solution.numberToWords(123)
    res should be("One Hundred Twenty Three")
  }

  "12345" should "get Twelve Thousand Three Hundred Forty Five" in {
    val res = Solution.numberToWords(12345)
    res should be("Twelve Thousand Three Hundred Forty Five")
  }

  "1234567" should "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" in {
    val res = Solution.numberToWords(1234567)
    res should be("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven")
  }

  "1234567891" should "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One" in {
    val res = Solution.numberToWords(1234567891)
    res should be("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One")
  }

  "1000000" should "One Million" in {
    val res = Solution.numberToWords(1000000)
    res should be("One Million")
  }
}

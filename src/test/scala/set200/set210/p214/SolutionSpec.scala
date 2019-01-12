package set200.set210.p214

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "aacecaaa" should "get aaacecaaa" in {
    val res = Solution.shortestPalindrome("aacecaaa")
    res should be("aaacecaaa")
  }

  "abcde" should "get edcbabcde" in {
    val res = Solution.shortestPalindrome("abcde")
    res should be("edcbabcde")
  }
}

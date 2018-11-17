package set000.set000.p005

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get bab out of babad" in {
    val res = Solution.longestPalindrome("babad")
    res shouldEqual "bab"
  }

  it should "get bb out of cbbd" in {
    val res = Solution.longestPalindrome("cbbd")
    res shouldEqual "bb"
  }

  it should "get bb out of bb" in {
    val res = Solution.longestPalindrome("bb")
    res shouldEqual "bb"
  }
}

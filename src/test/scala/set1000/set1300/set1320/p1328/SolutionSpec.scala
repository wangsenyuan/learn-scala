package set1000.set1300.set1320.p1328

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.breakPalindrome("abccba") should be("aaccba")
  }

  "example two" should "work" in {
    Solution.breakPalindrome("aba") should be("abb")
  }
}

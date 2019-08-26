package set0000.set300.set310.p316

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "bcabc" should "get abc" in {
    val res = Solution.removeDuplicateLetters("bcabc")
    res should equal("abc")
  }

  "cbacdcbc" should "get acdb" in {
    val res = Solution.removeDuplicateLetters("cbacdcbc")
    res should equal("acdb")
  }
}

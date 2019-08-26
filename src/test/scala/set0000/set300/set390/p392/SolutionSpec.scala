package set0000.set300.set390.p392

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "abc" should "be a subsequence of ahbgdc" in {
    val res = Solution.isSubsequence("abc", "ahbgdc")
    res should be(true)
  }

  "axc" should "not be a subsequence of ahbgdc" in {
    val res = Solution.isSubsequence("axc", "ahbgdc")
    res should be(false)
  }
}

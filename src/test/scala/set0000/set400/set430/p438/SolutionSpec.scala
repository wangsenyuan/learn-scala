package set0000.set400.set430.p438

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "cbaebabacd and abc" should "get [0, 6]" in {
    val res = Solution.findAnagrams("cbaebabacd", "abc")
    res should equal(List(0, 6))
  }

  "abab and ab" should "get [0, 1, 2]" in {
    val res = Solution.findAnagrams("abab", "ab")
    res should equal(List(0, 1, 2))
  }
}

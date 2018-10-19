package set000.set000.p003

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 3 in the abcabcbb" in {
    val res = Solution.lengthOfLongestSubstring("abcabcbb")
    res shouldBe 3
  }

  it should "get 1 in the bbbbb" in {
    val res = Solution.lengthOfLongestSubstring("bbbbb")
    res shouldBe 1
  }

  it should "get 3 in the pwwkew" in {
    val res = Solution.lengthOfLongestSubstring("pwwkew")
    res shouldBe 3
  }
}

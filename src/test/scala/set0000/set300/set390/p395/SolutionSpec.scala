package set0000.set300.set390.p395

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "aaabb & 3" should "get 3" in {
    val res = Solution.longestSubstring("aaabb", 3)
    res should be(3)
  }

  "ababbc & 2" should "get 5" in {
    val res = Solution.longestSubstring("ababbc", 2)
    res should be(5)
  }

  "aaaaa & 2" should "get 5" in {
    val res = Solution.longestSubstring("aaaaa", 2)
    res should be(5)
  }

  "abcde & 2" should "get 0" in {
    val res = Solution.longestSubstring("abcde", 2)
    res should be(0)
  }

  "aaabbb & 3" should "get 6" in {
    val res = Solution.longestSubstring("aaabbb", 3)
    res should be(6)
  }
}

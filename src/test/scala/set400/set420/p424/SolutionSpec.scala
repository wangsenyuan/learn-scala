package set400.set420.p424

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "ABAB & 2" should "get 4" in {
    val res = Solution.characterReplacement("ABAB", 2)
    res should be(4)
  }

  "AABABBA & 1" should "get 4" in {
    val res = Solution.characterReplacement("AABABBA", 1)
    res should be(4)
  }

  "AABABBA & 2" should "get 5" in {
    val res = Solution.characterReplacement("AABABBA", 2)
    res should be(5)
  }

  "AABABBA & 3" should "get 7" in {
    val res = Solution.characterReplacement("AABABBA", 3)
    res should be(7)
  }
}

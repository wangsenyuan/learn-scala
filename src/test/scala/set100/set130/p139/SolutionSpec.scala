package set100.set130.p139

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example 1" should "work" in {
    val s = "leetcode"
    val words = List("leet", "code")
    Solution.wordBreak(s, words) should be(true)
  }

  "example 2" should "work" in {
    val s = "applepenapple"
    val words = List("apple", "pen")
    Solution.wordBreak(s, words) should be(true)
  }

  "example 3" should "work" in {
    val s = "catsandog"
    val words = List("cats", "dog", "sand", "and", "cat")
    Solution.wordBreak(s, words) should be(false)
  }
}

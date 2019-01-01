package set100.set140.p140

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val s = "catsanddog"
    val words = List("cat", "cats", "and", "sand", "dog")
    val res = Solution.wordBreak(s, words)
    val expect = List("cats and dog", "cat sand dog").sorted
    res.sorted should equal(expect)
  }

  "example two" should "work" in {
    val s = "pineapplepenapple"
    val words = List("apple", "pen", "applepen", "pine", "pineapple")
    val res = Solution.wordBreak(s, words)
    val expect = List("pine apple pen apple", "pineapple pen apple", "pine applepen apple").sorted
    res.sorted should equal(expect)
  }

  "example three" should "work" in {
    val s = "catsandog"
    val words = List("cats", "dog", "sand", "and", "cat")
    val res = Solution.wordBreak(s, words)
    res.sorted should equal(Nil)
  }

  "example four" should "work" in {
    val s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    val words = List("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
    val res = Solution.wordBreak(s, words)
    res.sorted should equal(Nil)
  }
}

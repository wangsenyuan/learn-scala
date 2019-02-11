package set300.set340.p345

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "hello" should "get holle" in {
    val res = Solution.reverseVowels("hello")
    res should equal("holle")
  }

  "leetcode" should "get leotcede" in {
    val res = Solution.reverseVowels("leetcode")
    res should equal("leotcede")
  }
}

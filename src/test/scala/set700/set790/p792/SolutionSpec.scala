package set700.set790.p792

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val S = "abcde"
    val words = Array("a", "bb", "acd", "ace")
    val res = Solution.numMatchingSubseq(S, words)
    res should be(3)
  }

  "example two" should "work" in {
    val S = "dsahjpjauf"
    val words = Array("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax")
    val res = Solution.numMatchingSubseq(S, words)
    res should be(2)
  }

  "example three" should "work" in {
    val S = "qlhxagxdqh"
    val words = Array("qlhxagxdq", "qlhxagxdq", "lhyiftwtut", "yfzwraahab")
    val res = Solution.numMatchingSubseq(S, words)
    res should be(2)
  }
}

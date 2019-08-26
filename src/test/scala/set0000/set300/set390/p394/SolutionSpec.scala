package set0000.set300.set390.p394

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "3[a]2[bc]" should "be decoded to aaabcbc" in {
    val res = Solution.decodeString("3[a]2[bc]")
    res should equal("aaabcbc")
  }

  "3[a2[c]]" should "be decoded to accaccacc" in {
    val res = Solution.decodeString("3[a2[c]]")
    res should equal("accaccacc")
  }

  "2[abc]3[cd]ef" should "be decoded to abcabccdcdcdef" in {
    val res = Solution.decodeString("2[abc]3[cd]ef")
    res should equal("abcabccdcdcdef")
  }
}

package set000.set040.p044

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get false when given (aa, a)" in {
    val res = Solution.isMatch("aa", "a")
    res shouldBe false
  }

  it should "get true when given (aa, *)" in {
    val res = Solution.isMatch("aa", "*")
    res shouldBe true
  }

  it should "get false when given (cb, ?a)" in {
    val res = Solution.isMatch("cb", "?a")
    res shouldBe false
  }

  it should "get true when given (adceb,*a*b)" in {
    val res = Solution.isMatch("adceb", "*a*b")
    res shouldBe true
  }

  it should "get false when given (acdcb, a*c?b)" in {
    val res = Solution.isMatch("acdcb", "a*c?b")
    res shouldBe false
  }

  it should "get true when given ('', *)" in {
    val res = Solution.isMatch("", "*")
    res shouldBe true
  }

  it should "get false when given (aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba, a*******b)" in {
    val res = Solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b")
    res shouldBe false
  }

  it should "get true when given (aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba, a*******a)" in {
    val res = Solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******a")
    res shouldBe true
  }
}

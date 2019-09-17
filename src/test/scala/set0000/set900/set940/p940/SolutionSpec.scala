package set0000.set900.set940.p940

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    Solution.distinctSubseqII("abc") should be(7)
  }

  "example two" should "work" in {
    Solution.distinctSubseqII("aba") should be(6)
  }

  "example three" should "work" in {
    Solution.distinctSubseqII("aaa") should be(3)
  }

  "example four" should "work" in {
    Solution.distinctSubseqII("eeef") should be(7)
  }

  "example five" should "work" in {
    Solution.distinctSubseqII("ababababab") should be(231)
  }
}

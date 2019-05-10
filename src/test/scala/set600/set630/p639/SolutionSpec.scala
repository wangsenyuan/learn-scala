package set600.set630.p639

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.numDecodings("1*")
    res should be(18)
  }

  "example two" should "work" in {
    val res = Solution.numDecodings("*1*1*0")
    res should be(404)
  }

  "example three" should "work" in {
    val res = Solution.numDecodings("1*72*")
    res should be(285)
  }

  "example four" should "work" in {
    val res = Solution.numDecodings("1*7")
    res should be(19)
  }

  "example five" should "work" in {
    val res = Solution.numDecodings("********")
    res should be(123775776)
  }
}

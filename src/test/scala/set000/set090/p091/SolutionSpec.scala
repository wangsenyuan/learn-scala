package set000.set090.p091

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "12" should "get 2" in {
    Solution.numDecodings("12") should be(2)
  }

  "226" should "get 3" in {
    Solution.numDecodings("226") should be(3)
  }

  "0" should "get 0" in {
    Solution.numDecodings("0") should be(0)
  }

  "10" should "get 1" in {
    Solution.numDecodings("10") should be(1)
  }

  "00" should "get 0" in {
    Solution.numDecodings("00") should be(0)
  }

  "01" should "get 0" in {
    Solution.numDecodings("01") should be(0)
  }
}

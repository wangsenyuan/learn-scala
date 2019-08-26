package set0000.set000.set080.p087

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "great and rgeat" should "be scramble pairs" in {
    Solution.isScramble("great", "rgeat") should be(true)
  }

  "abcde and caebd" should "not be scramble pairs" in {
    Solution.isScramble("abcde", "caebd") should be(false)
  }


  "abc and bca" should "be scramble pairs" in {
    Solution.isScramble("abc", "bca") should be(true)
  }
}

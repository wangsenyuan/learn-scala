package set0000.set000.set060.p065

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "0" should "be valid" in {
    val res = Solution.isNumber("0")
    res shouldBe true
  }

  "\" 0.1 \"" should "be valid number" in {
    Solution.isNumber(" 0.1 ") should be(true)
  }

  "abc" should "not be a valid number" in {
    Solution.isNumber("abc") should be(false)
  }

  "1 a" should "not be a valid number" in {
    Solution.isNumber("1 a") should be(false)
  }

  "2e10" should "be a valid number" in {
    Solution.isNumber("2e10") should be(true)
  }

  " -90e3   " should "be a valid number" in {
    Solution.isNumber(" -90e3   ") should be(true)
  }

  " 1e" should "not ba a valid number" in {
    Solution.isNumber(" 1e") should be(false)
  }

  "e3" should "not be a valid number" in {
    Solution.isNumber("e3") should be(false)
  }

  " 6e-1" should "be a valid number" in {
    Solution.isNumber(" 6e-1") should be(true)
  }

  " 99e2.5 " should "not be a valid number" in {
    Solution.isNumber(" 99e2.5 ") should be(false)
  }

  "53.5e93" should "be a valid number" in {
    Solution.isNumber("53.5e93") should be(true)
  }

  " --6 " should "not be a valid number" in {
    Solution.isNumber(" --6 ") should be(false)
  }

  "-+3" should "not be a valid number" in {
    Solution.isNumber("-+3") should be(false)
  }

  "95a54e53" should "not be a valid number" in {
    Solution.isNumber("95a54e53") should be(false)
  }

  "." should "not be a valid number" in {
    Solution.isNumber(".") should be(false)
  }

  "-." should "not be a valid number" in {
    Solution.isNumber(".") should be(false)
  }

  "3." should "be a valid number" in {
    Solution.isNumber("3.") should be(true)
  }
}


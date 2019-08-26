package set0000.set000.set010.p012

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get III when convert 3" in {
    val res = Solution.intToRoman(3)
    res shouldBe "III"
  }

  it should "get IV when convert 4" in {
    val res = Solution.intToRoman(4)
    res shouldBe "IV"
  }

  it should "get IX when convert 9" in {
    val res = Solution.intToRoman(9)
    res shouldBe "IX"
  }

  it should "get LVIII when convert 58" in {
    val res = Solution.intToRoman(58)
    res shouldBe "LVIII"
  }

  it should "get MCMXCIV when convert 1994" in {
    val res = Solution.intToRoman(1994)
    res shouldBe "MCMXCIV"
  }
}

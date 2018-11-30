package set000.set010.p013

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 3 when convert III" in {
    val res = Solution.romanToInt("III")
    res shouldBe 3
  }

  it should "get 9 when convert IX" in {
    val res = Solution.romanToInt("IX")
    res shouldBe 9
  }

  it should "get 58 when convert LVIII" in {
    val res = Solution.romanToInt("LVIII")
    res shouldBe 58
  }

  it should "get 1994 when covert MCMXCIV" in {
    val res = Solution.romanToInt("MCMXCIV")
    res shouldBe 1994
  }
}

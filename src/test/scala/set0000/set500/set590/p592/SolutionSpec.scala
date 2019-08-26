package set0000.set500.set590.p592

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val str = "-1/2+1/2"
    val res = Solution.fractionAddition(str)
    res should be("0/1")
  }

  "example two" should "work" in {
    val str = "-1/2+1/2+1/3"
    val res = Solution.fractionAddition(str)
    res should be("1/3")
  }

  "example three" should "work" in {
    val str = "1/3-1/2"
    val res = Solution.fractionAddition(str)
    res should be("-1/6")
  }

  "example four" should "work" in {
    val str = "5/3+1/3"
    val res = Solution.fractionAddition(str)
    res should be("2/1")
  }
}

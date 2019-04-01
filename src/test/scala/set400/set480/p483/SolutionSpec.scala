package set400.set480.p483

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "13" should "get 3" in {
    val res = Solution.smallestGoodBase("13")
    res should be("3")
  }

  "4681" should "get 8" in {
    val res = Solution.smallestGoodBase("4681")
    res should be("8")
  }

  "1000000000000000000" should "get 999999999999999999" in {
    val res = Solution.smallestGoodBase("1000000000000000000")
    res should be("999999999999999999")
  }
}

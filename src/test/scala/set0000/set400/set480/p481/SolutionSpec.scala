package set0000.set400.set480.p481

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "6" should "get 3" in {
    val res = Solution.magicalString(6)
    res should be(3)
  }

  "13" should "get 6" in {
    val res = Solution.magicalString(13)
    res should be(6)
  }
}

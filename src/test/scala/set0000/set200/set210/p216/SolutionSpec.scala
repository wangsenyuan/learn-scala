package set0000.set200.set210.p216

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "k = 3 and n = 7" should "work" in {
    val res = Solution.combinationSum3(3, 7)
    res should equal(List(List(1, 2, 4)))
  }
}

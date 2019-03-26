package set400.set460.p464

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "10 & 11" should "get false" in {
    val res = Solution.canIWin(10, 11)
    res should be(false)
  }

  "10 & 0" should "get true" in {
    val res = Solution.canIWin(10, 0)
    res should be(true)
  }

  "5 & 50" should "get false" in {
    val res = Solution.canIWin(5, 50)
    res should be(false)
  }
}

package set0000.set200.set270.p279

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "12" should "get 3" in {
    val res = Solution.numSquares(12)
    res should be(3)
  }

  "13" should "get 2" in {
    val res = Solution.numSquares(13)
    res should be(2)
  }
}

package set100.set180.p188

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[2,4,1] and 2" should "get 2" in {
    val res = Solution.maxProfit(2, Array(2, 4, 1))
    res should be(2)
  }

  "[3,2,6,5,0,3] and 2" should "get 7" in {
    val res = Solution.maxProfit(2, Array(3, 2, 6, 5, 0, 3))
    res should be(7)
  }
}

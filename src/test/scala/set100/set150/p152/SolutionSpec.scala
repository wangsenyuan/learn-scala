package set100.set150.p152

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2,3,-2,4" should "get 6" in {
    val res = Solution.maxProduct(Array(2, 3, -2, 4))
    res should be(6)
  }

  "-2,0,-1" should "get 0" in {
    val res = Solution.maxProduct(Array(-2, 0, -1))
    res should be(0)
  }
}

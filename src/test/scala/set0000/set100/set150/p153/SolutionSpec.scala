package set0000.set100.set150.p153

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[4,5,6,7,0,1,2]" should "get 0" in {
    val res = Solution.findMin(Array(4, 5, 6, 7, 0, 1, 2))
    res should be(0)
  }
}

package set0000.set100.set170.p174

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[[1,-3,3],[0,-2,0],[-3,-3,-3]]" should "get 3" in {
    val res = Solution.calculateMinimumHP(Array(Array(1, -3, 3), Array(0, -2, 0), Array(-3, -3, -3)))
    res should be(3)
  }
}

package set400.set400.p403

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[0,1,3,5,6,8,12,17]" should "get true" in {
    val res = Solution.canCross(Array(0, 1, 3, 5, 6, 8, 12, 17))
    res should be(true)
  }

  "[0,1,2,3,4,8,9,11]" should "get false" in {
    val res = Solution.canCross(Array(0, 1, 2, 3, 4, 8, 9, 11))
    res should be(false)
  }
}

package set100.set190.p190

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,2,3,4,5,6,7] and 3" should "get [5,6,7,1,2,3,4]" in {
    val nums = Array(1, 2, 3, 4, 5, 6, 7)
    Solution2.rotate(nums, 3)
    nums should equal(Array(5, 6, 7, 1, 2, 3, 4))
  }
}

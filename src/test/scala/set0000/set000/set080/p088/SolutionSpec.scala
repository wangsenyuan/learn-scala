package set0000.set000.set080.p088

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "merge 1,2,3 and 2,5,6" should "get 1,2,2,3,5,6" in {
    val nums1 = Array(1, 2, 3, 0, 0, 0)
    val nums2 = Array(2, 5, 6)
    Solution.merge(nums1, 3, nums2, 3)
    nums1 should equal(Array(1, 2, 2, 3, 5, 6))
  }
}

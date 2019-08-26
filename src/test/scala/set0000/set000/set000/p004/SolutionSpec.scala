package set0000.set000.set000.p004

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "give 2 in the sample [1, 3], [2]" in {
    val nums1 = Array(1, 3)
    val nums2 = Array(2)
    val res = Solution.findMedianSortedArrays(nums1, nums2)
    res shouldEqual 2.0
  }

  it should "give 2.5 in the sample [1, 3], [2, 4]" in {
    val nums1 = Array(1, 3)
    val nums2 = Array(2, 4)
    val res = Solution.findMedianSortedArrays(nums1, nums2)
    res shouldEqual 2.5
  }


  it should "give 2 in the sample [2, 2], [2, 2]" in {
    val nums1 = Array(2, 2)
    val nums2 = Array(2, 2)
    val res = Solution.findMedianSortedArrays(nums1, nums2)
    res shouldEqual 2.0
  }
}

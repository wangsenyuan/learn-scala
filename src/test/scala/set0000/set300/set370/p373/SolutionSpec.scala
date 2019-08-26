package set0000.set300.set370.p373

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "nums1 = [1,7,11], nums2 = [2,4,6], k = 3" should "get [[1,2],[1,4],[1,6]] " in {
    val nums1 = Array(1, 7, 11)
    val nums2 = Array(2, 4, 6)
    val res = Solution.kSmallestPairs(nums1, nums2, 3)
    res.flatMap(x => x) should equal(List(1, 2, 1, 4, 1, 6))
  }

  "nums1 = [1,1,2], nums2 = [1,2,3], k = 2" should "get [1,1],[1,1] " in {
    val nums1 = Array(1, 1, 2)
    val nums2 = Array(1, 2, 3)
    val res = Solution.kSmallestPairs(nums1, nums2, 2)
    res.flatMap(x => x) should equal(List(1, 1, 1, 1))
  }

  "nums1 = [1,1,2], nums2 = [1,2,3], k = 10" should "get [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]] " in {
    val nums1 = Array(1, 1, 2)
    val nums2 = Array(1, 2, 3)
    val res = Solution.kSmallestPairs(nums1, nums2, 10)
    res.flatMap(x => x) should equal(List(1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 3, 1, 3, 2, 3))
  }
}

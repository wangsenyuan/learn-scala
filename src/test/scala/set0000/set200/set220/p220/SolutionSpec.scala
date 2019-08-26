package set0000.set200.set220.p220

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,5,9,1,5,9], t = 3, and k = 2" should "get false" in {
    val nums = Array(1, 5, 9, 1, 5, 9)
    val t = 3
    val k = 2
    val res = Solution.containsNearbyAlmostDuplicate(nums, k, t)
    res should be(false)
  }

  "[-1, -1], t = -1, and k = 1" should "get false" in {
    val nums = Array(-1, -1)
    val t = -1
    val k = 1
    val res = Solution.containsNearbyAlmostDuplicate(nums, k, t)
    res should be(false)
  }

  "[-1,2147483647] and k = 1, t = 2147483647" should "get false" in {
    val nums = Array(-1, 2147483647)
    val t = 2147483647
    val k = 1
    val res = Solution.containsNearbyAlmostDuplicate(nums, k, t)
    res should be(false)
  }
}

package set000.set010.p016

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 2 when deal with [-1, 2, 1, -4], 1" in {
    val nums = Array(-1, 2, 1, -4)
    val target = 1
    val res = Solution.threeSumClosest(nums, target)
    res shouldBe 2
  }

  it should "get 3 when deal with [1, 1, 1, 1], 0" in {
    val nums = Array(1, 1, 1, 1)
    val target = 0
    val res = Solution.threeSumClosest(nums, target)
    res shouldBe 3
  }
}

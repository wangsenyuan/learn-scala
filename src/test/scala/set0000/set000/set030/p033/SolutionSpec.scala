package set0000.set000.set030.p033

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 4 when nums = [4,5,6,7,0,1,2], target = 0" in {
    val nums = Array(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    val res = Solution.search(nums, target)
    res shouldBe 4
  }

  it should "get -1 when nums = [4,5,6,7,0,1,2], target = 3" in {
    val nums = Array(4, 5, 6, 7, 0, 1, 2)
    val target = 3
    val res = Solution.search(nums, target)
    res shouldBe -1
  }

  it should "get 1 when nums = [1， 3], target = 3" in {
    val nums = Array(1, 3)
    val target = 3
    val res = Solution.search(nums, target)
    res shouldBe 1
  }

  it should "get -1 when nums = [3, 1], target = 0" in {
    val nums = Array(3, 1)
    val target = 0
    val res = Solution.search(nums, target)
    res shouldBe -1
  }

  it should "get 2 when nums = [3, 1, 2], target = 2" in {
    val nums = Array(3, 1, 2)
    val target = 2
    val res = Solution.search(nums, target)
    res shouldBe 2
  }
}

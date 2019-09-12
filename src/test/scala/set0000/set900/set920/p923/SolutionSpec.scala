package set0000.set900.set920.p923

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
    val target = 8
    val res = Solution.threeSumMulti(nums, target)
    res should be(20)
  }

  "example two" should "work" in {
    val nums = Array(1, 1, 2, 2, 2, 2)
    val target = 5
    val res = Solution.threeSumMulti(nums, target)
    res should be(12)
  }
}

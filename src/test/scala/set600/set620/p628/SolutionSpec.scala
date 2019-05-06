package set600.set620.p628

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val nums = Array(-9,-10,1,2,3,4,5,6,7,8)
    val res = Solution.maximumProduct(nums)
    res should be(720)
  }
}

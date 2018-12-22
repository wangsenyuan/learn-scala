package set000.set090.p090

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[1,2,2]" should "get a result with size 6" in {
    val nums = Array(1, 2, 2)
    val res = Solution.subsetsWithDup(nums)
    res.size should be(6)
  }
}

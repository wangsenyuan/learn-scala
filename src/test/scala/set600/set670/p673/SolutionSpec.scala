package set600.set670.p673

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[1,3,5,4,7]" should "get 2" in {
    val res = Solution.findNumberOfLIS(Array(1,3,5,4,7))
    res should be(2)
  }

  "[2,2,2,2,2]" should "get 5" in {
    val res = Solution.findNumberOfLIS(Array(2,2,2,2,2))
    res should be(5)
  }
}

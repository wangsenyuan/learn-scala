package set700.set750.p757

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(Array(2,10), Array(3,7), Array(3,15), Array(4,11), Array(6,12), Array(6,16), Array(7,8), Array(7,11), Array(7,15), Array(11,12))
    val res = Solution.intersectionSizeTwo(nums)

    res should be(5)
  }

  "example two" should "work" in {
    val nums = Array(Array(4,14), Array(6,17), Array(7,14), Array(14,21), Array(4,7))
    val res = Solution.intersectionSizeTwo(nums)

    res should be(4)
  }
}

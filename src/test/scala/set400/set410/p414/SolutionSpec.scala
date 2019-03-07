package set400.set410.p414

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1, 2, 2]" should "get 2" in {
    val res = Solution.thirdMax(Array(1, 2, 2))
    res should be(2)
  }

  "[1,2,-2147483648]" should "get -2147483648" in {
    val res = Solution.thirdMax(Array(1,2,-2147483648))
    res should be(-2147483648)
  }
}

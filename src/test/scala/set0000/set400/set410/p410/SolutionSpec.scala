package set0000.set400.set410.p410

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[7,2,5,10,8] & 2" should "get 18" in {
    val res = Solution.splitArray(Array(7,2,5,10,8), 2)
    res should be(18)
  }

  "[1, 2147483647] & 2" should "get 2147483647" in {
    val res = Solution.splitArray(Array(1, 2147483647), 2)
    res should be(2147483647)
  }
}

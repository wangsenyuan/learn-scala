package set200.set270.p275

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[0,1,3,5,6]" should "get 3" in {
    val res = Solution.hIndex(Array(0, 1, 3, 5, 6))
    res should be(3)
  }

  "[0]" should "get 0" in {
    val res = Solution.hIndex(Array(0))
    res should be(0)
  }

  "[100]" should "get 1" in {
    val res = Solution.hIndex(Array(100))
    res should be(1)
  }
}

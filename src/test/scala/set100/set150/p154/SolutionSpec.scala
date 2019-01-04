package set100.set150.p154

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2,2,2,0,1" should "get 0" in {
    val res = Solution.findMin(Array(2, 2, 2, 0, 1))
    res should be(0)
  }

  "2,2,2,0,1,2" should "get 0" in {
    val res = Solution.findMin(Array(2, 2, 2, 0, 1, 2))
    res should be(0)
  }

  "3,1" should "get 1" in {
    val res = Solution.findMin(Array(3, 1))
    res should be(1)
  }
}

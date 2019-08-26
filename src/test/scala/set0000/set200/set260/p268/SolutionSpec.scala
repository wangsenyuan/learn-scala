package set0000.set200.set260.p268

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3,0,1]" should "find 2" in {
    val res = Solution.missingNumber(Array(3, 0, 1))
    res should be(2)
  }

  "[0]" should "find 1" in {
    val res = Solution.missingNumber(Array(0))
    res should be(1)
  }

  "[0, 1]" should "find 2" in {
    val res = Solution.missingNumber(Array(0, 1))
    res should be(2)
  }

  "[1, 0]" should "find 2" in {
    val res = Solution.missingNumber(Array(1, 0))
    res should be(2)
  }
}

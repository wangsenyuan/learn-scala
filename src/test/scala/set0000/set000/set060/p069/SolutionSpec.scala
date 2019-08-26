package set0000.set000.set060.p069

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "sqrt of 4" should "be 2" in {
    val res = Solution.mySqrt(4)
    res should be(2)
  }

  "sqrt of 8" should "be 2" in {
    val res = Solution.mySqrt(8)
    res should be(2)
  }
}

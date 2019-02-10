package set300.set330.p338

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2" should "get [0,1,1]" in {
    val res = Solution.countBits(2)
    res should equal(Array(0, 1, 1))
  }

  "5" should "get [0,1,1,2,1,2]" in {
    val res = Solution.countBits(5)
    res should equal(Array(0, 1, 1, 2, 1, 2))
  }
}

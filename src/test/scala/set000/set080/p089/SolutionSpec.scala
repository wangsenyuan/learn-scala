package set000.set080.p089

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2" should "get [0, 1, 3, 2]" in {
    val res = Solution.grayCode(2)
    res should equal(List(0, 1, 3, 2))
  }

  "3" should "get [0, 1, 3, 2, 6, 7, 5, 4]" in {
    val res = Solution.grayCode(3)
    res should equal(List(0, 1, 3, 2, 6, 7, 5, 4))
  }
}

package set0000.set800.set890.p898

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.subarrayBitwiseORs(Array(1, 2, 4))
    res should be(6)
  }

  "example two" should "work" in {
    val res = Solution.subarrayBitwiseORs(Array(39, 19, 30, 56, 79, 50, 19, 70, 30))
    res should be(17)
  }
}

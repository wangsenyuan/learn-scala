package set0000.set900.set970.p974

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(4, 5, 0, -2, -3, 1)
    val K = 5
    val res = Solution.subarraysDivByK(arr, K)
    res should be(7)
  }
}

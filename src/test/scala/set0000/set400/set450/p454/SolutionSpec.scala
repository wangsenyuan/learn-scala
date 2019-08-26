package set0000.set400.set450.p454

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 17" in {
    val A = Array(0, 1, -1)
    val B = Array(-1, 1, 0)
    val C = Array(0, 0, 1)
    val D = Array(-1, 1, 1)
    val res = Solution.fourSumCount(A, B, C, D)
    res should be(17)
  }
}

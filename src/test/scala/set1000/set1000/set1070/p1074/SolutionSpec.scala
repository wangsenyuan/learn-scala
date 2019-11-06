package set1000.set1000.set1070.p1074

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val matrix = Array(Array(0, 1, 0), Array(1, 1, 1), Array(0, 1, 0))
    val res = Solution.numSubmatrixSumTarget(matrix, 0)
    res should be(4)
  }
}

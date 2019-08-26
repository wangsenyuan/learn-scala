package set0000.set300.set360.p363

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "matrix = [[1,0,1],[0,-2,3]], k = 2" should "get 2" in {
    val res = Solution.maxSumSubmatrix(Array(Array(1, 0, 1), Array(0, -2, 3)), 2)
    res should be(2)
  }
}

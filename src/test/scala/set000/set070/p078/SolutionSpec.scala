package set000.set070.p078

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1,2,3" should "get a result with size 8" in {
    val res = Solution.subsets(Array(1, 2, 3))
    res.size should be(8)
  }
}

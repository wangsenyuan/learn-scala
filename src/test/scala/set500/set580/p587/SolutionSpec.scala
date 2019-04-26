package set500.set580.p587

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example two" should "work" in {
    val points = Array(Array(0, 2), Array(1, 1), Array(2, 2), Array(2, 4), Array(4, 2), Array(3, 3))
    val res = Solution.outerTrees(points)
    res.size should be(5)
  }
}

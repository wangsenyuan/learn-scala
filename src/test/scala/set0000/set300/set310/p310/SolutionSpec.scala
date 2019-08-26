package set0000.set300.set310.p310

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get [1]" in {
    val n = 4
    val edges = Array(Array(1, 0), Array(1, 2), Array(1, 3))
    val res = Solution.findMinHeightTrees(n, edges)
    res should equal(List(1))
  }

  "example two" should "get [3, 4]" in {
    val n = 6
    val edges = Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5, 4))
    val res = Solution.findMinHeightTrees(n, edges)
    res should equal(List(3, 4))
  }
}

package set600.set680.p685

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val edges = Array(Array(4,2), Array(1,5), Array(5,2), Array(5,3), Array(2,4))
    val res = Solution.findRedundantDirectedConnection(edges)
    res should equal(Array(4, 2))
  }

  "example two" should "work" in {
    val edges = Array(Array(1,2), Array(1,3), Array(2,3))
    val res = Solution.findRedundantDirectedConnection(edges)
    res should equal(Array(2, 3))
  }

  "example three" should "work" in {
    val edges = Array(Array(2,1), Array(3,1), Array(4,2), Array(1, 4))
    val res = Solution.findRedundantDirectedConnection(edges)
    res should equal(Array(2, 1))
  }
}

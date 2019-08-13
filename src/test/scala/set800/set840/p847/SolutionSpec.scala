package set800.set840.p847

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val graph = Array(Array(1, 2, 3), Array(0), Array(0), Array(0))
    val res = Solution.shortestPathLength(graph)
    res should be(4)
  }

  "example two" should "work" in {
    val graph = Array(Array(1), Array(0, 2, 4), Array(1, 3, 4), Array(2), Array(1, 2))
    val res = Solution.shortestPathLength(graph)
    res should be(4)
  }
}

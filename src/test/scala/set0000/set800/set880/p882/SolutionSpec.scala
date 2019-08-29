package set0000.set800.set880.p882

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val edges = Array(Array(0, 1, 10), Array(0, 2, 1), Array(1, 2, 2))
    val M = 6
    val N = 3
    val res = Solution.reachableNodes(edges, M, N)
    res should be(13)
  }

  "example two" should "work" in {
    val edges = Array(Array(0, 1, 4), Array(1, 2, 6), Array(0, 2, 8), Array(1, 3, 1))
    val M = 10
    val N = 4
    val res = Solution.reachableNodes(edges, M, N)
    res should be(23)
  }


  "example three" should "work" in {
    val edges = Array(Array(2, 4, 2), Array(3, 4, 5), Array(2, 3, 1), Array(0, 2, 1), Array(0, 3, 5))
    val M = 14
    val N = 5
    val res = Solution.reachableNodes(edges, M, N)
    res should be(18)
  }

  "example four" should "work" in {
    val edges = Array(Array(4, 6, 11), Array(5, 6, 2), Array(2, 6, 11), Array(0, 3, 19), Array(1, 7, 21), Array(5, 7, 1), Array(1, 5, 4), Array(0, 7, 12), Array(6, 7, 3), Array(3, 6, 22), Array(0, 5, 24), Array(1, 2, 8), Array(3, 7, 11), Array(1, 3, 14), Array(4, 5, 7), Array(4, 7, 14), Array(0, 4, 5), Array(2, 4, 7), Array(3, 4, 11), Array(3, 5, 15), Array(2, 5, 13), Array(2, 3, 6), Array(1, 4, 6), Array(0, 2, 3), Array(1, 6, 20))
    val M = 18
    val N = 8
    val res = Solution.reachableNodes(edges, M, N)
    res should be(233)
  }
}

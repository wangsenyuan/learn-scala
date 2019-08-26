package set0000.set800.set830.p834

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val n = 6
    val edges = Array(Array(0, 1), Array(0, 2), Array(2, 3), Array(2, 4), Array(2, 5))
    val res = Solution.sumOfDistancesInTree(n, edges)
    res should equal(Array(8, 12, 6, 10, 10, 10))
  }

  "example two" should "work" in {
    val n = 7
    val edges = Array(Array(0, 1), Array(0, 2), Array(2, 3), Array(2, 4), Array(2, 5), Array(5, 6))
    val res = Solution.sumOfDistancesInTree(n, edges)
    res should equal(Array(11, 16, 8, 13, 13, 11, 16))
  }
}

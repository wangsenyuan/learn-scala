package set0000.set200.set210.p218

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val buildings = Array(Array(2, 9, 10), Array(3, 7, 15), Array(5, 12, 12), Array(15, 20, 10), Array(19, 24, 8))
    val res = Solution.getSkyline(buildings)
    res should equal(List(Array(2, 10), Array(3, 15), Array(7, 12), Array(12, 0), Array(15, 10), Array(20, 8), Array(24, 0)))
  }
}

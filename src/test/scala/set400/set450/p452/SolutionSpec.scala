package set400.set450.p452

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val points = Array(Array(10, 16), Array(2, 8), Array(1, 6), Array(7, 12))
    val res = Solution.findMinArrowShots(points)
    res should be(2)
  }

  "example two" should "work" in {
    val points = Array(Array(9, 12), Array(1, 10), Array(4, 11), Array(8, 12), Array(3, 9), Array(6, 9), Array(6, 7))
    val res = Solution.findMinArrowShots(points)
    res should be(2)
  }
}

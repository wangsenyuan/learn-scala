package set100.set140.p149

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 3" in {
    val points = Array(new Point(1, 1), new Point(2, 2), new Point(3, 3))
    val res = Solution.maxPoints(points)
    res should be(3)
  }

  "example two" should "get 4" in {
    val points = Array(new Point(1, 1), new Point(3, 2), new Point(5, 3), new Point(4, 1), new Point(2, 3), new Point(1, 4))
    val res = Solution.maxPoints(points)
    res should be(4)
  }

  "example three" should "get 3" in {
    val points = Array(new Point(0, 0), new Point(1, 1), new Point(0, 0))
    val res = Solution.maxPoints(points)
    res should be(3)
  }

  "example four" should "get 3" in {
    val points = Array(new Point(1, 1), new Point(1, 1), new Point(1, 1))
    val res = Solution.maxPoints(points)
    res should be(3)
  }


  "example five" should "get 8" in {
    val points = Array(new Point(0, -1), new Point(0, 3),
      new Point(0, -4), new Point(0, 0), new Point(0, 0), new Point(0, 1), new Point(0, -2), new Point(0, 4))
    val res = Solution.maxPoints(points)
    res should be(8)
  }
}

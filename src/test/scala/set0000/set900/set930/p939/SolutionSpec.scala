package set0000.set900.set930.p939

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val points = Array(Array(1, 1), Array(1, 3), Array(3, 1), Array(3, 3), Array(2, 2))
    val res = Solution.minAreaRect(points)
    res should be(4)
  }

  "example two" should "work" in {
    val points = Array(Array(1, 1), Array(1, 3), Array(3, 1), Array(3, 3), Array(4, 1), Array(4, 3))
    val res = Solution.minAreaRect(points)
    res should be(2)
  }
}

package set0000.set900.set960.p963

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val points = Array(Array(1, 2), Array(2, 1), Array(1, 0), Array(0, 1))
    val res = Solution.minAreaFreeRect(points)
    (res - 2.0).abs should be < (0.0000001)
  }

  "example two" should "work" in {
    val points = Array(Array(0, 1), Array(2, 1), Array(1, 1), Array(1, 0), Array(2, 0))
    val res = Solution.minAreaFreeRect(points)
    (res - 1.0).abs should be < (0.0000001)
  }

  "example three" should "work" in {
    val points = Array(Array(0, 3), Array(1, 2), Array(3, 1), Array(1, 3), Array(2, 1))
    val res = Solution.minAreaFreeRect(points)
    (res - 0.0).abs should be < (0.0000001)
  }

  "example four" should "work" in {
    val points = Array(Array(3, 1), Array(1, 1), Array(0, 1), Array(2, 1), Array(3, 3), Array(3, 2), Array(0, 2), Array(2, 3))
    val res = Solution.minAreaFreeRect(points)
    (res - 2.0).abs should be < (0.0000001)
  }
}

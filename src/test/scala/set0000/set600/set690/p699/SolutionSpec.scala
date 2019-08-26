package set0000.set600.set690.p699

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val positions = Array(Array(1, 2), Array(2, 3), Array(6, 1))
    val res = Solution.fallingSquares(positions)
    res should equal(List(2, 5, 5))
  }

  "example two" should "work" in {
    val positions = Array(Array(9, 7), Array(1, 9), Array(3, 1))
    val res = Solution.fallingSquares(positions)
    res should equal(List(7,16,17))
  }

  "example three" should "work" in {
    val positions = Array(Array(100, 100), Array(200, 100))
    val res = Solution.fallingSquares(positions)
    res should equal(List(100, 100))
  }
}

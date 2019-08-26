package set0000.set700.set770.p778

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(Array(0, 2), Array(1, 3))
    val res = Solution.swimInWater(grid)
    res should be(3)
  }

  "example two" should "work" in {
    val grid = Array(Array(0, 1, 2, 3, 4), Array(24, 23, 22, 21, 5), Array(12, 13, 14, 15, 16), Array(11, 17, 18, 19, 20), Array(10, 9, 8, 7, 6))
    val res = Solution.swimInWater(grid)
    res should be(16)
  }
}

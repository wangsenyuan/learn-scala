package set0000.set900.set950.p959

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(" /", "/ ")
    val res = Solution.regionsBySlashes(grid)
    res should be(2)
  }

  "example two" should "work" in {
    val grid = Array(" /", "  ")
    val res = Solution.regionsBySlashes(grid)
    res should be(1)
  }

  "example three" should "work" in {
    val grid = Array("\\/", "/\\")
    val res = Solution.regionsBySlashes(grid)
    res should be(4)
  }

  "example four" should "work" in {
    val grid = Array("/\\", "\\/")
    val res = Solution.regionsBySlashes(grid)
    res should be(5)
  }
}

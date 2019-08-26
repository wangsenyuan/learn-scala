package set0000.set700.set740.p749

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(
      Array(0, 1, 0, 0, 0, 0, 0, 1),
      Array(0, 1, 0, 0, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 0, 0, 0, 1),
      Array(0, 0, 0, 0, 0, 0, 0, 0),
    )
    val res = Solution.containVirus(grid)
    res should be(10)
  }

  "example two" should "work" in {
    val grid = Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1),
    )
    val res = Solution.containVirus(grid)
    res should be(4)
  }

  "example three" should "work" in {
    val grid = Array(
      Array(1, 1, 1, 0, 0, 0, 0, 0, 0),
      Array(1, 0, 1, 0, 1, 1, 1, 1, 1),
      Array(1, 1, 1, 0, 0, 0, 0, 0, 0),
    )
    val res = Solution.containVirus(grid)
    res should be(13)
  }
}

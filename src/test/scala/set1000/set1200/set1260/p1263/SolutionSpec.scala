package set1000.set1200.set1260.p1263

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(
      Array("#", "#", "#", "#", "#", "#"),
      Array("#", "T", "#", "#", "#", "#"),
      Array("#", ".", ".", "B", ".", "#"),
      Array("#", ".", "#", "#", ".", "#"),
      Array("#", ".", ".", ".", "S", "#"),
      Array("#", "#", "#", "#", "#", "#")
    ).map(row => row.map(_.charAt(0)))

    val res = Solution.minPushBox(grid)

    res should be(3)
  }
}

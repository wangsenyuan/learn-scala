package set0000.set200.set200.p200

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(Array("1", "1", "1", "1", "0"), Array("1", "1", "0", "1", "0"), Array("1", "1", "0", "0", "0"), Array("0", "0", "0", "0", "0"))

    val grid = nums.map(_.map(_.charAt(0)))

    val res = Solution.numIslands(grid)

    res should be(1)
  }

  "example two" should "work" in {
    val nums = Array(Array("1", "1", "1"), Array("1", "1", "1"), Array("1", "1", "1"))

    val grid = nums.map(_.map(_.charAt(0)))

    val res = Solution.numIslands(grid)

    res should be(1)
  }
}
